package generated

final case class Data925(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data925 = copy(name = name.toUpperCase)
  def scale(k: Double): Data925 = copy(value = value * k)
  def addTag(t: String): Data925 = copy(tags = t :: tags)
  def put(k: String, v: String): Data925 = copy(meta = meta.updated(k, v))
  def merge(other: Data925): Data925 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data925 {
  given Ordering[Data925] = Ordering.by(_.id)
  def empty: Data925 = Data925(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data925 =
    Data925(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data925] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
