package generated

final case class Data354(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data354 = copy(name = name.toUpperCase)
  def scale(k: Double): Data354 = copy(value = value * k)
  def addTag(t: String): Data354 = copy(tags = t :: tags)
  def put(k: String, v: String): Data354 = copy(meta = meta.updated(k, v))
  def merge(other: Data354): Data354 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data354 {
  given Ordering[Data354] = Ordering.by(_.id)
  def empty: Data354 = Data354(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data354 =
    Data354(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data354] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
