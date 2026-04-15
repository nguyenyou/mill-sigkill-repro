package generated

final case class Data55(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data55 = copy(name = name.toUpperCase)
  def scale(k: Double): Data55 = copy(value = value * k)
  def addTag(t: String): Data55 = copy(tags = t :: tags)
  def put(k: String, v: String): Data55 = copy(meta = meta.updated(k, v))
  def merge(other: Data55): Data55 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data55 {
  given Ordering[Data55] = Ordering.by(_.id)
  def empty: Data55 = Data55(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data55 =
    Data55(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data55] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
