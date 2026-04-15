package generated

final case class Data813(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data813 = copy(name = name.toUpperCase)
  def scale(k: Double): Data813 = copy(value = value * k)
  def addTag(t: String): Data813 = copy(tags = t :: tags)
  def put(k: String, v: String): Data813 = copy(meta = meta.updated(k, v))
  def merge(other: Data813): Data813 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data813 {
  given Ordering[Data813] = Ordering.by(_.id)
  def empty: Data813 = Data813(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data813 =
    Data813(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data813] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
