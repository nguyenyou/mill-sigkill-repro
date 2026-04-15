# Mill 1.x: incremental compile breaks when alternating between two shells

Minimal reproduction of a Mill / Zinc incremental-compile bug that shows up
when a Scala module is compiled alternately from two different shell
environments — for example, Claude Code's `Bash` tool versus a user's
regular terminal. Each invocation invalidates the other's Zinc analysis
and forces a full rebuild of the module, even when only one source file
changed.

If the same shell is used throughout, incremental compile works
correctly.

## Environment

- macOS (tested on Darwin 25.3, Apple Silicon)
- Mill 1.1.5
- Scala 3.8.3
- Single shared Mill daemon (pid stays the same across both shells)

## Expected

After editing exactly one source file, `./mill repro.compile` should
report:

```
compiling 1 Scala source to out/repro/compile.dest/classes ...
```

## Actual

When the previous compile was run from the *other* shell, Mill instead
reports:

```
compiling 5 Scala sources to out/repro/compile.dest/classes ...
```

i.e. the whole module is recompiled from scratch. All `.class` and
`.tasty` files are rewritten with new mtimes; for the four unchanged
sources the new bytes are identical to the old bytes (deterministic
compilation), so only the edited file's outputs actually differ in
content.
