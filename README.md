# Mill SIGKILL compile repro

A minimal Mill project that reproduces, in about thirty seconds, the following
observation:

> If you `SIGKILL` a running `./mill compile`, the next `./mill compile` has
> to redo **all** of the work, even though nothing in the sources has changed.

The repro shows why, with numbers and on-disk state, and pinpoints the layer
where the work is actually being lost. Spoiler: it isn't Mill's cache.

## Why it matters

Claude Code's Bash tool kills interrupted shell commands with
`tree-kill(pid, 'SIGKILL')`, with no prior `SIGTERM` grace window. Any time
you interrupt a running `./mill compile` from inside Claude Code — pressing
escape, running `/compact`, starting a new message while the old one is
still executing — the compile JVM is SIGKILL'd instantly.

The visible effect: your Mill compile "starts over" every time this happens,
and the user-observable story becomes "Claude Code invalidates Mill's cache."
That isn't quite what's going on. This repro nails down what actually is.

## Running the repro

```bash
./prep.sh 1500        # generate 1500 tiny Scala source files
./experiment.sh       # run Tests A–E
```

```bash
-> mill-sigkill-repro ./experiment.sh 

============================================================
TEST A: baseline cold compile (empty cache)
============================================================
real 14.11
user 0.04
sys 0.09

============================================================
TEST B: no-op compile (full cache, cold daemon)
============================================================
real 1.02
user 0.01
sys 0.02

============================================================
TEST C: SIGKILL the compile at 10s, then inspect on-disk state
============================================================
user 0.00
sys 0.00
time: signal: Invalid argument

State of out/repro/compile.dest immediately after SIGKILL:
  classfiles: 0
  tasty     : 0
  zinc file : NO
  compile.json: NO

============================================================
TEST D: re-run compile after SIGKILL (cold daemon)
============================================================
real 14.10
user 0.05
sys 0.09

============================================================
TEST E: sanity-check — dest intact, only compile.json missing
============================================================
real 2.28
user 0.01
sys 0.03

Done.
```

`prep.sh` generates `repro/src/generated/Data{1..N}.scala`. 1500 files give a
~14s cold compile on an M-series Mac, which is comfortably long enough to
`SIGKILL` partway through. Tune `N` up or down for your machine.

Requires GNU coreutils `timeout` (`brew install coreutils` on macOS — the
BSD `timeout` doesn't accept `--signal=KILL`).

## What the experiment measures

Five back-to-back tests, each starting from a cold Mill daemon so daemon
warmth doesn't skew the numbers. Representative times on an M3:

| Test | Setup                                                     | Time   |
|------|-----------------------------------------------------------|--------|
| A    | Empty cache, full compile                                 | 14.2 s |
| B    | Full cache, no source changes                             | 1.1 s  |
| C    | Empty cache, start compile, SIGKILL at 10 s               | killed |
| D    | Re-run compile after Test C's SIGKILL                     | 14.1 s |
| E    | Delete only `compile.json`, keep `compile.dest` intact    | 2.3 s  |

Tests A and B set the floor and ceiling for "how fast should a compile be".
Test D is the problem: a re-run after SIGKILL that takes just as long as the
original cold compile. Test E is the control that pins down where the problem
isn't.

## On-disk state after the SIGKILL

Test C runs `timeout --signal=KILL 10 ./mill repro.compile` — SIGKILL at the
10-second mark, 71% of the way through a 14-second cold compile. Immediately
after the kill, `out/repro/compile.dest/` contains:

```
classfiles:  0
tasty     :  0
zinc file :  NO
compile.json: NO
```

Seven seconds of actual compilation work have gone by, and the compiler has
written **zero** classfiles, **zero** `.tasty` files, and no zinc analysis
blob. That is the whole finding in one table: the Scala 3 compiler plus zinc
batches all of its output and flushes it at the very end of a compile run.
Anything that kills the JVM before that final flush leaves no trace on disk.

## The failure mode, step by step

A cold `./mill repro.compile` does roughly this:

1. Wrapper startup + Mill daemon handshake + JVM warmup — about 1–2 s.
2. Classpath resolution, zinc bridge compilation, worker setup — about 1–2 s.
3. dotc runs typer → erasure → codegen on all 1500 source files, entirely in
   JVM memory. About 8–10 s.
4. dotc returns; zinc writes every classfile and `.tasty` file to `compile.dest/classes/`.
5. Zinc writes its incremental-compile analysis blob to `compile.dest/zinc`
   via `ConsistentFileAnalysisStore` (temp file + atomic rename).
6. Mill's task body returns successfully; Mill writes `out/repro/compile.json`
   with the inputs hash, value hash, Mill version, etc.

SIGKILL at any point between steps 1 and 4 produces the state shown above:
empty dest, no analysis, no task metadata. The compiler is sitting on all of
its in-memory state when the kernel yanks the JVM out from under it.

SIGKILL between 4 and 5 would leave classfiles but no analysis — zinc without
analysis can't do an incremental compile, so the next run is still a full
rebuild. SIGKILL between 5 and 6 leaves a valid dest but no `compile.json`,
which is what Test E simulates.

## Test E: Mill's cache layer is doing the right thing

The point of Test E is to separate "Mill forgot the cache" from "zinc has
nothing to resume from". It deletes only `out/repro/compile.json` (Mill's
per-task metadata), leaving `compile.dest/` fully populated from the previous
successful compile. Then it runs `./mill repro.compile` and measures.

Result: **2.3 seconds**. Here is what happened in that 2.3 s:

- Mill started (cold daemon), loaded its build, saw no `compile.json` for the
  `repro.compile` task, and therefore treated the task as uncached.
- Because `compile` is declared with `Task(persistent = true)`
  (`libs/javalib/src/mill/javalib/JavaModule.scala:977`), Mill **did not**
  wipe `compile.dest`. The dest-wipe code in
  `core/exec/src/mill/exec/GroupExecution.scala:313` is gated on
  `!labelled.persistent`.
- Mill re-ran the task body, which invoked the zinc worker.
- Zinc loaded its analysis blob from `compile.dest/zinc` via
  `ConsistentFileAnalysisStore` (`libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:742`).
- Zinc compared source hashes to the analysis, found no changes, and
  compiled nothing.
- Mill wrote a fresh `compile.json`.

The 2.3 s is daemon startup, classpath resolution, and zinc opening its
analysis file. Zero compile work happened. If Mill were wiping `compile.dest`
behind the scenes, this test would match Test D at ~14 s — and it doesn't.

So Mill's caching is intact. The `.meta` file is just a summary; the
authoritative compile state lives inside `compile.dest`, and Mill preserves
that across runs. The problem in Test D is that `compile.dest` is empty after
SIGKILL, not that Mill forgot to look at it.

## Why it isn't trivially fixable in Mill

Mill is already doing everything it reasonably can:

- `compile` is marked persistent, so dest survives across task re-runs.
- Zinc's analysis store is atomic (temp file + rename), so the on-disk blob
  is never truncated or half-written — it's always either the last committed
  state or absent, never corrupt.
- Mill's task cache file is separate from dest, so a missing or stale
  `compile.json` doesn't trigger a dest wipe.

The missing piece is incremental persistence *during* the compile, and that
lives one layer below Mill:

- **dotc holds the entire compilation unit graph in memory** until the
  backend phase finishes for the last unit. There is no periodic flush.
- **zinc writes classfiles in one batch** when dotc returns, then writes its
  analysis blob. Until that moment, the only copy of the compiled output
  exists in the JVM heap.

SIGKILL during that in-memory phase is unrecoverable by construction. You
can't resume a compile that never left memory.

## Actual paths to mitigation

1. **Flush incrementally in dotc.** Have each compilation unit emit its
   classfiles as soon as codegen is done for that unit, and have zinc update
   its analysis after each unit rather than in one final write. This is a
   real compiler change and a real change to zinc's `AnalysisStore` contract.
   It's the clean fix, and it's the only one that would make mid-compile
   SIGKILL actually cheap.

2. **Chunk the compile in Mill.** Feed zinc N files at a time instead of all
   at once. Each chunk becomes a natural commit point. This is slower than
   one big compile under normal conditions because zinc pays per-invocation
   overhead on each chunk, so it would only make sense as an opt-in for
   environments where compiles are routinely interrupted.

3. **SIGTERM before SIGKILL in the caller.** Claude Code's Bash tool
   currently calls `treeKill(pid, 'SIGKILL')` directly. Sending `SIGTERM`
   first with a short grace window (1–2 s) wouldn't rescue work killed deep
   inside dotc — dotc has no signal handler for flushing — but it *would*
   rescue the narrow window between "dotc finished" and "Mill wrote
   `compile.json`", where all the real work is already in memory and just
   needs to be handed to zinc's final-write path. A cheap win for the cost
   of two seconds of delay on interrupt.

Option 3 is the one you can land without touching Mill or dotc.

## Project layout

```
mill-sigkill-repro/
├── mill              # Mill 1.1.5 wrapper
├── build.mill        # single ScalaModule, Scala 3.8.3
├── prep.sh           # generates repro/src/generated/Data{1..N}.scala
├── experiment.sh     # runs Tests A–E end-to-end
├── README.md         # this file
└── repro/
    └── src/generated/  # gitignored, populated by prep.sh
```

`build.mill` is three lines of real content:

```scala
object repro extends ScalaModule {
  def scalaVersion = "3.8.3"
}
```

## Versions used when writing this

- Mill 1.1.5
- Scala 3.8.3
- JDK 21
- macOS 15 (Darwin 25), Apple M3
- GNU coreutils `timeout` 9.10 from homebrew

## Source-code pointers

All line numbers are from the `master` branch of `com-lihaoyi/mill` as of
April 2026. Clone with `git clone --depth=1 https://github.com/com-lihaoyi/mill`
to follow along.

- `libs/javalib/src/mill/javalib/JavaModule.scala:977` — `def compile =
  Task(persistent = true) { ... }`. This is the declaration that keeps
  `compile.dest` alive across re-runs.
- `core/exec/src/mill/exec/GroupExecution.scala:313` — the dest-wipe, gated
  on `!labelled.persistent`. No-op for compile.
- `core/exec/src/mill/exec/GroupExecution.scala:618` — `writeCacheJson`
  writes `compile.json` after the task body returns successfully. Uses
  `os.write.over` (not atomic, but out of the critical path for this bug).
- `libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:426` — the
  zinc analysis store is opened at `workDir / zincCache`, which resolves to
  `compile.dest/zinc`.
- `libs/javalib/worker/src/mill/javalib/zinc/ZincWorker.scala:742` —
  `fileAnalysisStore` uses `ConsistentFileAnalysisStore.binary`, zinc's
  temp-file-plus-rename atomic writer.
