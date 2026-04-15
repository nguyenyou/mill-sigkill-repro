# Scala 3 incremental compile is silently invalidated when two Mill clients with different TTY state alternate

## TL;DR

On Scala 3, `ZincWorker` conditionally prepends `-color:never` to `scalacOptions` based on the current client's `colored` flag (`libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:470`). `colored` is per-RPC, so two clients that resolve `colored` differently produce two different `scalacOptions` for the same module. That gets baked into Zinc's `MiniSetup`, and any `MiniSetup` mismatch is a full Zinc invalidation — so alternating between the two clients cold-recompiles the whole module on every source edit.

I hit this by asking [Claude Code](https://www.anthropic.com/claude-code) to run `./mill repro.compile` (it executes the command via its `Bash` tool), alongside a regular interactive zsh terminal as the other client. That specific combination is what I've actually reproduced; plain `bash -c './mill repro.compile'` from a script does **not** reproduce it for me.

Mill itself is not wiping `compile.dest`; Zinc is. Mill's `inputsHash` does not include `colored`, so the mismatch is invisible to Mill and sits latent on disk until the next edit forces the compile body to re-run.

## Minimal repro

`build.mill`:

```scala
package build
import mill._, mill.scalalib._
object repro extends ScalaModule { def scalaVersion = "3.8.3" }
```

With any Scala 3 source file under `repro/src/`, starting from a clean `out/`:

1. Ask [Claude Code](https://www.anthropic.com/claude-code) to run `./mill repro.compile` (it executes the command via its `Bash` tool). Full compile. The baked `MiniSetup` now has `-color:never`.
2. Edit one source file.
3. From an **interactive zsh terminal**, run `./mill repro.compile` ⇒ **full cold rebuild of every source**, not just the edited one.

## Root cause

`ZincWorker.compileInternal` (`libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:470`):

```scala
val addColorNeverOption = Option.when(
  !localConfig.logPromptColored &&
    compilers.scalac().scalaInstance().version().startsWith("3.") &&
    !scalacOptions.exists(_.startsWith("-color:"))
) { "-color:never" }
val finalScalacOptions = addColorNeverOption.toSeq ++ scalacOptions
```

`logPromptColored` comes from `log.prompt.colored`, which is recomputed per client RPC from `mainInteractive`/`env` at `runner/daemon/src/mill/daemon/MillMain0.scala:168`. The injected option is never fed back into Mill's input hashing — it is observed inside the worker `apply` and written straight into Zinc's `MiniSetup` analysis file. Next call, `MiniSetup` comparison fails, Zinc invalidates everything.

## Workaround

Pin `scalacOptions` in `build.mill` so the condition `!scalacOptions.exists(_.startsWith("-color:"))` is always false:

```scala
def scalacOptions = Seq("-color:never")
```

Verified end-to-end on the minimal repro.

## Suggested upstream fix

Runtime logger state should not leak into compiler `MiniSetup`. Cleanest fix: pre-normalize `scalacOptions` before handing them to Zinc so `-color:*` is excluded from the `MiniSetup` comparison key (but still applied at compile time). Alternatives: always inject `-color:never` unconditionally, or never inject it and handle color purely at log-rendering time.

---

<details>
<summary><b>Environment</b></summary>

- Mill `1.1.5`
- Scala `3.8.3`
- macOS 25 (Apple Silicon)
- Zulu JDK 21.0.10 (downloaded via Coursier by Mill)
- Single Mill background daemon shared across both clients — PID stable, verified via `out/mill-daemon/processId` and `ps`

</details>

<details>
<summary><b>Full repro cycle with observed output</b></summary>

Two clients against the same daemon:

- **Client B** — [Claude Code](https://www.anthropic.com/claude-code) running `./mill repro.compile` via its `Bash` tool (i.e. I tell Claude Code to run the command and it shells out through its Bash tool). This is the only non-TTY client I've confirmed reproduces the issue; plain `bash -c './mill repro.compile'` from a script does not.
- **Client T** — interactive zsh terminal. `mainInteractive = true` ⇒ `colored = true`.

Starting from a clean `out/` with 5 trivial source files in the module:

| # | Client | Action | Mill output | Notes |
|---|---|---|---|---|
| 1 | B | `./mill repro.compile` | `compiling 5 Scala sources` | Cold start. Bakes `colored=false` `MiniSetup` (with `-color:never`) into `out/repro/compile.dest/zinc`. |
| 2 | — | edit one line | — | |
| 3 | B | `./mill repro.compile` | `compiling 1 Scala source` | Same TTY state as step 1. `MiniSetup` matches, true incremental. |
| 4 | T | `./mill repro.compile` (no edit) | *(no `compiling …` line — task body skipped)* | **Smoking gun.** Mill's `inputsHash` is unchanged, so the compile task body is not re-run. The `colored` mismatch sits latent on disk, invisible to Mill. |
| 5 | — | edit one line | — | |
| 6 | T | `./mill repro.compile` | `compiling 5 Scala sources` | Edit forces body to re-run. Worker now sees `colored=true`, builds `scalacOptions` *without* `-color:never`, hands them to Zinc; Zinc compares against stored `MiniSetup` (with `-color:never`), declares mismatch, cold-recompiles all 5. Every `.class`, `.tasty`, and the `zinc` analysis file get new inodes, but bytes for unchanged files are byte-identical. |

Step 4 is the part that distinguishes this from a Mill-cache-invalidation story: Mill's input layer is genuinely happy across clients. The corruption is purely in the on-disk Zinc analysis and stays latent until the next edit.

</details>

<details>
<summary><b>Fix verification (same cycle, with workaround)</b></summary>

After adding `def scalacOptions = Seq("-color:never")` and clearing `out/`:

| # | Client | Action | Mill output |
|---|---|---|---|
| 1 | B | `./mill repro.compile` | `compiling 5 Scala sources` |
| 2 | — | edit one line | — |
| 3 | B | `./mill repro.compile` | `compiling 1 Scala source` |
| 4 | T | `./mill repro.compile` (no edit) | *(no-op cache hit)* |
| 5 | — | edit one line | — |
| 6 | T | `./mill repro.compile` | **`compiling 1 Scala source`** |

Step 6 is the key: with `scalacOptions` pinned, the `ZincWorker.scala:474` conditional is bypassed for both clients, `MiniSetup` is identical regardless of `colored`, and Zinc's incremental analysis stays valid across the TTY transition.

</details>

<details>
<summary><b>Evidence it's Zinc invalidation, not a Mill <code>compile.dest</code> wipe</b></summary>

- `compile` is declared `Task(persistent = true)` at `libs/scalalib/src/mill/scalalib/ScalaModule.scala:329`, so its dest should be preserved across runs.
- The only `os.remove.all(paths.dest)` call in `core/exec` / `core/eval` / `runner` is at `core/exec/src/mill/exec/GroupExecution.scala:311`, gated by `!labelled.persistent`. Mill never deletes `compile.dest` for a persistent task.
- After the cross-TTY run, inodes of every `compile.dest/classes/**/*.class` and `*.tasty` change, but for unchanged sources the new bytes are byte-identical to the old bytes (deterministic Scala 3 output). That is consistent with Zinc rewriting the analysis via temp-file + atomic rename (`ConsistentFileAnalysisStore`), not with Mill wiping the directory.
- `out/mill-profile.json` for the cross-TTY run shows `valueHashChanged: true` only on the edit-induced chain `repro.sources → repro.allSources → repro.allSourceFiles → repro.compile`. Every other upstream task, including the `T.input` ones (`coursierEnv`, `useFileLocks`, `zincLogDebug`, `zincReportCachedProblems`, `compileResources`), reports `valueHashChanged: false`. Mill's input graph is clean.
- Same daemon PID across both clients, verified via `out/mill-daemon/processId` and `ps`.

</details>

<details>
<summary><b>Extended root cause walk-through</b></summary>

Mill recomputes `colored` on every client RPC at `runner/daemon/src/mill/daemon/MillMain0.scala:168`:

```scala
val noColorViaEnv    = env.get("NO_COLOR").exists(_.nonEmpty)
val forceColorViaEnv = env.get("FORCE_COLOR").exists(_.nonEmpty)
val colored = config.color.getOrElse(
  (mainInteractive || forceColorViaEnv) && !(noColorViaEnv || config.bsp.value)
)
```

`mainInteractive` and `env` are per-client RPC fields filled from `init.interactive` and `init.env` at `runner/server/src/mill/server/MillDaemonServer.scala:147,149`. Interactive zsh ⇒ `colored = true`; non-TTY subprocess ⇒ `colored = false`.

`colored` flows into `PromptLogger`, then `log.prompt.colored`, then `JvmWorkerImpl` builds a fresh `LocalConfig` per call at `libs/javalib/worker/src/mill/javalib/worker/JvmWorkerImpl.scala:31`:

```scala
val zincCtx = ZincWorker.LocalConfig(
  dest             = ctx.dest,
  logDebugEnabled  = log.debugEnabled,
  logPromptColored = log.prompt.colored,   // per-client TTY state
  workspaceRoot    = mill.api.BuildCtx.workspaceRoot
)
```

Then `ZincWorker.compileInternal` builds `finalScalacOptions` with the conditional `-color:never` (see snippet in the root-cause section above) and passes them into Zinc's `incrementalCompiler.inputs(...)`, which bakes them into `MiniSetup` and persists them in the analysis store at `Task.dest/zinc`. On the next compile, sbt-zinc compares old vs new `MiniSetup`; `scalacOptions` mismatch is a standard full-invalidation trigger, so every source is cold-recompiled. `ConsistentFileAnalysisStore` writes the analysis via temp-file + atomic rename, so even byte-identical analyses get a new inode.

`-color:never` is injected inside the worker `apply`, after Mill has finished computing `inputsHash`, and is never fed back into Mill's input graph. So `inputsHash` / `valueHash` for every upstream task is identical across clients, and Mill's cache layer never knows anything is wrong. The only thing that triggers re-running the compile body is the legitimate source edit — but once it re-runs, Zinc decides the `MiniSetup` is incompatible and goes cold.

</details>

<details>
<summary><b>Related code references</b></summary>

All paths relative to `com-lihaoyi/mill` at tag `1.1.5`:

- `libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:470` — Scala-3-only `-color:never` injection **(root cause)**
- `libs/javalib/worker/src/mill/javalib/worker/JvmWorkerImpl.scala:31` — `LocalConfig.logPromptColored` plumbed in
- `runner/daemon/src/mill/daemon/MillMain0.scala:168` — per-client `colored` resolution
- `runner/server/src/mill/server/MillDaemonServer.scala:147` — `mainInteractive` / `env` populated from RPC `init`
- `libs/scalalib/src/mill/scalalib/ScalaModule.scala:329` — `def compile = Task(persistent = true) { ... }`
- `core/exec/src/mill/exec/GroupExecution.scala:311` — only `os.remove.all(paths.dest)` site, gated by `!labelled.persistent`

</details>
