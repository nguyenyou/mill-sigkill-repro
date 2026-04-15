package generated

final case class Data824(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data824 = copy(name = name.toUpperCase)
  def scale(k: Double): Data824 = copy(value = value * k)
  def addTag(t: String): Data824 = copy(tags = t :: tags)
  def put(k: String, v: String): Data824 = copy(meta = meta.updated(k, v))
  def merge(other: Data824): Data824 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data824 {
  given Ordering[Data824] = Ordering.by(_.id)
  def empty: Data824 = Data824(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data824 =
    Data824(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data824] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
