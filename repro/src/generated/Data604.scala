package generated

final case class Data604(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data604 = copy(name = name.toUpperCase)
  def scale(k: Double): Data604 = copy(value = value * k)
  def addTag(t: String): Data604 = copy(tags = t :: tags)
  def put(k: String, v: String): Data604 = copy(meta = meta.updated(k, v))
  def merge(other: Data604): Data604 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data604 {
  given Ordering[Data604] = Ordering.by(_.id)
  def empty: Data604 = Data604(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data604 =
    Data604(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data604] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
