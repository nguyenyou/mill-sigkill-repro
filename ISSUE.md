# Scala 3 incremental compile breaks when alternating clients with different `colored` (TTY) state

## Summary

In Mill 1.1.5 with Scala 3, the per-client `colored` flag is silently injected as a `-color:never` scalacOption inside `ZincWorker`. Because Mill computes `colored` fresh on every RPC connection from the client's TTY/`env`, two clients with different interactivity (e.g. an interactive zsh terminal vs. a non-TTY subprocess such as an editor/CI tool/agent shell) produce two different `MiniSetup.scalacOptions` for the same module. Zinc treats any `MiniSetup` mismatch as a full invalidation, so editing a single source file and then alternating compiles between the two clients triggers a **cold full rebuild every time the client switches**, even though the Mill background daemon, JVM, classpath, source set, and `build.mill` are all unchanged.

The persistent `compile.dest/` directory is not literally deleted by Mill — Zinc just rewrites every `.class`, `.tasty`, and the analysis file from scratch (atomic temp+rename gives them new inodes). For deterministic Scala 3 builds the rewritten bytes for unchanged sources are byte-identical to the previous bytes, which is the giveaway that this is Zinc invalidation, not a Mill input change.

## Environment

- macOS 25 (Apple Silicon)
- Mill `1.1.5`
- Scala `3.8.3`
- Single Mill background daemon shared across both clients (PID stable; verified via `out/mill-daemon/processId`)
- Zulu JDK 21.0.10 (downloaded via Coursier by Mill)

## Minimal reproduction

`build.mill`:

```scala
package build

import mill._
import mill.scalalib._

object repro extends ScalaModule {
  def scalaVersion = "3.8.3"
}
```

Five trivial source files under `repro/src/` are enough; even a single file works for the toggle reproduction below. Any Scala 3 `ScalaModule` will do.

### Cycle

This is the cycle I actually executed against the minimal `build.mill` above. Two clients are involved against the same Mill background daemon (PID stable, verified via `out/mill-daemon/processId` and `ps`):

- **Client B** — [Claude Code](https://www.anthropic.com/claude-code)'s `Bash` tool, which spawns a non-TTY subprocess. `mainInteractive = false` ⇒ `colored = false`. (Any non-TTY caller behaves identically: an editor's "run shell command" action, a CI runner, a script invoked from another script, etc.)
- **Client T** — interactive zsh terminal. `mainInteractive = true` ⇒ `colored = true`.

Starting from a clean `out/`:

| # | Client | Action                                  | Mill output                                           | Notes                                                                                                                   |
|---|--------|-----------------------------------------|-------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| 1 | B      | `./mill repro.compile`                  | `compiling 5 Scala sources`                           | Cold start. Bakes `colored=false` `MiniSetup` (with `-color:never`) into `out/repro/compile.dest/zinc`.                 |
| 2 | —      | edit one line in `Data1.scala`           | —                                                     | Real code change, not a comment.                                                                                        |
| 3 | B      | `./mill repro.compile`                  | `compiling 1 Scala source`                            | Same TTY state as step 1. Zinc `MiniSetup` matches → true incremental. Data2–5 inodes preserved.                        |
| 4 | T      | `./mill repro.compile` (no edit)        | *(no `compiling …` line — task body skipped)*         | **The smoking-gun cache hit.** Mill's `inputsHash` is unchanged (it does not include `colored`), so the compile task body is not re-run. The `colored` mismatch is sitting latent on disk, **invisible to Mill**. |
| 5 | —      | edit one line in `Data1.scala`           | —                                                     |                                                                                                                         |
| 6 | T      | `./mill repro.compile`                  | `compiling 5 Scala sources`                           | The edit forces the body to re-run. Now the worker sees `colored=true`, builds `scalacOptions` *without* `-color:never`, hands them to Zinc; Zinc compares against the stored `MiniSetup` (which has `-color:never`), declares mismatch, cold-recompiles all 5 sources. Every `.class`, `.tasty`, and the `zinc` analysis file get **new inodes**, but the bytes for Data2–5 are byte-identical to the previous bytes. |

Step 4 is the part that distinguishes this from a "Mill cache invalidation" story: Mill's input layer is genuinely happy across clients. The corruption is purely in the on-disk Zinc analysis, and it stays latent until the next thing forces the compile body to actually run.

### Fix verification

After applying the workaround (`def scalacOptions = Seq("-color:never")` in `build.mill`) and clearing `out/`, I re-ran the exact same Repro A cycle:

| # | Client | Action                                  | Mill output (with fix)        |
|---|--------|-----------------------------------------|-------------------------------|
| 1 | B      | `./mill repro.compile`                  | `compiling 5 Scala sources`   |
| 2 | —      | edit one line in `Data1.scala`           | —                             |
| 3 | B      | `./mill repro.compile`                  | `compiling 1 Scala source`    |
| 4 | T      | `./mill repro.compile` (no edit)        | *(no-op cache hit)*           |
| 5 | —      | edit one line in `Data1.scala`           | —                             |
| 6 | T      | `./mill repro.compile`                  | **`compiling 1 Scala source`** |

Step 6 is the key: with `scalacOptions` pinned, the conditional injection at `ZincWorker.scala:474` is bypassed for both clients, the `MiniSetup` is identical regardless of `colored`, and Zinc's incremental analysis stays valid across the TTY transition.

## Expected

After editing one source file, `./mill repro.compile` reports:

```
compiling 1 Scala source to out/repro/compile.dest/classes ...
```

regardless of which client (TTY or not) is invoking it.

## Actual

When the previous compile was run with a different effective `colored` value, Mill instead reports:

```
compiling N Scala sources to out/repro/compile.dest/classes ...
```

i.e. the whole module recompiles cold.

## Evidence that this is Zinc invalidation, not a Mill cache wipe

- Inodes of `compile.dest/classes/generated/*.class` and `*.tasty` change for **every** file after a cross-client run, but the bytes for unchanged sources are byte-identical (deterministic Scala 3 compilation).
- `out/repro/compile.dest/zinc` analysis file gets a new inode and a slightly different size after the cross-client run.
- `out/mill-profile.json` shows only `repro.sources → repro.allSources → repro.allSourceFiles → repro.compile` with `valueHashChanged: true`. Every other upstream task (including the `T.input` ones — `coursierEnv`, `useFileLocks`, `zincLogDebug`, `zincReportCachedProblems`, `compileResources`) reports `valueHashChanged: false`. Mill's input graph is clean.
- `compile` is declared `Task(persistent = true)` (`libs/scalalib/src/mill/scalalib/ScalaModule.scala:329`).
- The only `os.remove.all(paths.dest)` site in `core/exec`/`core/eval`/`runner` is `core/exec/src/mill/exec/GroupExecution.scala:311`, gated by `!labelled.persistent`. So Mill never deletes `compile.dest` for `compile`.
- Same daemon PID is reused across both clients (verified via `out/mill-daemon/processId` and `ps`).

## Root cause

Mill recomputes the `colored` boolean on every client RPC from the client's `interactive`/`env` (`runner/daemon/src/mill/daemon/MillMain0.scala:168`):

```scala
val noColorViaEnv   = env.get("NO_COLOR").exists(_.nonEmpty)
val forceColorViaEnv = env.get("FORCE_COLOR").exists(_.nonEmpty)
val colored = config.color.getOrElse(
  (mainInteractive || forceColorViaEnv) && !(noColorViaEnv || config.bsp.value)
)
```

Both `mainInteractive` and `env` are per-client RPC fields filled in from `init.interactive` and `init.env` in `runner/server/src/mill/server/MillDaemonServer.scala:147,149`. An interactive zsh terminal yields `colored = true`; a non-TTY subprocess with no overriding env vars yields `colored = false`.

`colored` flows into `PromptLogger`, then `log.prompt.colored`, then `JvmWorkerImpl` builds a fresh `LocalConfig` per call (`libs/javalib/worker/src/mill/javalib/worker/JvmWorkerImpl.scala:31`):

```scala
val zincCtx = ZincWorker.LocalConfig(
  dest             = ctx.dest,
  logDebugEnabled  = log.debugEnabled,
  logPromptColored = log.prompt.colored,   // ← per-client TTY state
  workspaceRoot    = mill.api.BuildCtx.workspaceRoot
)
```

And inside `ZincWorker.compileInternal` (`libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:470`):

```scala
val addColorNeverOption = Option.when(
  !localConfig.logPromptColored &&
    compilers.scalac().scalaInstance().version().startsWith("3.") &&
    !scalacOptions.exists(_.startsWith("-color:"))
) { "-color:never" }
val finalScalacOptions = addColorNeverOption.toSeq ++ scalacOptions
```

This is a Scala 3-only conditional injection of `-color:never` into `scalacOptions`, applied **after** Mill has finished hashing inputs, and never fed back into Mill's input graph. The resulting `scalacOptions` are baked into Zinc's `MiniSetup` via the analysis store at `Task.dest/zinc`. On the next compile, sbt-zinc compares the previous `MiniSetup` against the new one; a `scalacOptions` mismatch is a standard Zinc full-invalidation trigger and causes every source to be cold-recompiled. The `ConsistentFileAnalysisStore` writes the analysis via temp-file + atomic rename, so even byte-identical analyses get a new inode — which is why "the whole `compile.dest/classes` looks wiped" even though no Mill code has called `os.remove.all` on it.

This also explains why none of Mill's input-tracking surfaces show anything wrong: `colored` is observed inside the worker `apply` and is invisible to Mill's `inputsHash`/`valueHash` machinery, so every upstream task hashes identically across clients. The only thing that triggers re-running the compile body is the legitimate source edit — but once it re-runs, Zinc decides the `MiniSetup` is incompatible and goes cold.

## Workarounds

Pin scalacOptions in `build.mill`, which makes `scalacOptions.exists(_.startsWith("-color:"))` true and bypasses the conditional injection at `ZincWorker.scala:474`:
```scala
def scalacOptions = Seq("-color:never")
```
Verified end-to-end on the minimal repro: alternating clients with single-file edits now consistently produces `compiling 1 Scala source`, and `compile.dest/classes/*.class` inodes are preserved for unchanged files.

## Suggested upstream fix

Runtime logger state should not leak into compiler `MiniSetup`. Options, in rough order of preference:

1. **Strip color flags from the `MiniSetup` Zinc compares.** Zinc lets you customize the `extra` / `MiniSetup` equality via `ScalaCompilerForUnitTesting`-style hooks; alternately Mill can pre-normalize `scalacOptions` before handing them to Zinc so that `-color:*` is excluded from the analysis-comparison key but still applied at compile time.
2. **Always inject `-color:never`** (or never inject it) regardless of TTY state, and instead post-process the compiler's diagnostic output for color in `PromptLogger` if colored output is desired.
3. **Make `logPromptColored` an explicit input** to the `compile` task hash so that Mill at least invalidates downstream consistently. (This would still cause unnecessary recompiles on every TTY change but would make the behavior predictable instead of mysterious.)

Option 1 is the cleanest: there is no semantic reason for Zinc's incremental analysis to depend on whether the build tool's terminal supports ANSI colors.

## Related code references

All paths relative to `com-lihaoyi/mill` at tag `1.1.5`:

- `libs/scalalib/src/mill/scalalib/ScalaModule.scala:329` — `def compile = Task(persistent = true) { ... }`
- `core/exec/src/mill/exec/GroupExecution.scala:311` — only `os.remove.all(paths.dest)` site, gated by `!labelled.persistent`
- `runner/daemon/src/mill/daemon/MillMain0.scala:168` — per-client `colored` resolution
- `runner/server/src/mill/server/MillDaemonServer.scala:147` — `mainInteractive` / `env` populated from RPC `init`
- `libs/javalib/worker/src/mill/javalib/worker/JvmWorkerImpl.scala:31` — `LocalConfig.logPromptColored` plumbed in
- `libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:470` — Scala-3-only `-color:never` injection
