#!/usr/bin/env bash
# Generates N Scala source files to make compile take long enough
# that you can SIGKILL the Mill process mid-compile.
set -euo pipefail

N="${1:-600}"
OUT=repro/src/generated
rm -rf "$OUT"
mkdir -p "$OUT"

for i in $(seq 1 "$N"); do
  cat > "$OUT/Data$i.scala" <<EOF
package generated

final case class Data$i(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data$i = copy(name = name.toUpperCase)
  def scale(k: Double): Data$i = copy(value = value * k)
  def addTag(t: String): Data$i = copy(tags = t :: tags)
  def put(k: String, v: String): Data$i = copy(meta = meta.updated(k, v))
  def merge(other: Data$i): Data$i = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data$i {
  given Ordering[Data$i] = Ordering.by(_.id)
  def empty: Data$i = Data$i(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data$i =
    Data$i(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data$i] =
    (1 to n).iterator.map(i => of(i, s"item-\$i")).toList
}
EOF
done

echo "Generated $N files in $OUT/"
