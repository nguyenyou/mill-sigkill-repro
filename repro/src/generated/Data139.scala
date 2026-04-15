package generated

final case class Data139(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data139 = copy(name = name.toUpperCase)
  def scale(k: Double): Data139 = copy(value = value * k)
  def addTag(t: String): Data139 = copy(tags = t :: tags)
  def put(k: String, v: String): Data139 = copy(meta = meta.updated(k, v))
  def merge(other: Data139): Data139 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data139 {
  given Ordering[Data139] = Ordering.by(_.id)
  def empty: Data139 = Data139(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data139 =
    Data139(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data139] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
