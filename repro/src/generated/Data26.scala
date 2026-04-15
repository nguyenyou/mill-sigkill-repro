package generated

final case class Data26(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data26 = copy(name = name.toUpperCase)
  def scale(k: Double): Data26 = copy(value = value * k)
  def addTag(t: String): Data26 = copy(tags = t :: tags)
  def put(k: String, v: String): Data26 = copy(meta = meta.updated(k, v))
  def merge(other: Data26): Data26 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data26 {
  given Ordering[Data26] = Ordering.by(_.id)
  def empty: Data26 = Data26(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data26 =
    Data26(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data26] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
