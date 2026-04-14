#!/usr/bin/env bash
# Reproduces the "SIGKILL invalidates the Mill compile cache" observation.
# Runs three tests back-to-back and prints the timings so you can compare.
#
# Usage:
#   ./prep.sh 1500     # generate sources (once)
#   ./experiment.sh    # run the experiment
set -u

stop_mill() {
  ./mill shutdown >/dev/null 2>&1 || true
  pkill -9 -f "mill.*$(pwd)" 2>/dev/null || true
  sleep 1
}

section() {
  echo
  echo "============================================================"
  echo "$1"
  echo "============================================================"
}

section "TEST A: baseline cold compile (empty cache)"
stop_mill
rm -rf out/repro/compile.dest out/repro/compile.json
/usr/bin/time -p ./mill repro.compile 2>&1 | tail -3

section "TEST B: no-op compile (full cache, cold daemon)"
stop_mill
/usr/bin/time -p ./mill repro.compile 2>&1 | tail -3

section "TEST C: SIGKILL the compile at 10s, then inspect on-disk state"
stop_mill
rm -rf out/repro/compile.dest out/repro/compile.json
/usr/bin/time -p timeout --signal=KILL 10 ./mill repro.compile 2>&1 | tail -3 || true
echo
echo "State of out/repro/compile.dest immediately after SIGKILL:"
find out/repro/compile.dest -name '*.class' 2>/dev/null | wc -l | awk '{print "  classfiles:", $1}'
find out/repro/compile.dest -name '*.tasty' 2>/dev/null | wc -l | awk '{print "  tasty     :", $1}'
if [ -f out/repro/compile.dest/zinc ]; then
  echo "  zinc file : YES ($(stat -f %z out/repro/compile.dest/zinc) bytes)"
else
  echo "  zinc file : NO"
fi
echo "  compile.json: $([ -f out/repro/compile.json ] && echo YES || echo NO)"

section "TEST D: re-run compile after SIGKILL (cold daemon)"
stop_mill
/usr/bin/time -p ./mill repro.compile 2>&1 | tail -3

section "TEST E: sanity-check — dest intact, only compile.json missing"
# Shows that Mill correctly reuses the persistent dest when zinc data is there.
stop_mill
rm -f out/repro/compile.json
/usr/bin/time -p ./mill repro.compile 2>&1 | tail -3

echo
echo "Done."
