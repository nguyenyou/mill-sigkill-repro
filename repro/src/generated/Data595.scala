package generated

final case class Data595(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data595 = copy(name = name.toUpperCase)
  def scale(k: Double): Data595 = copy(value = value * k)
  def addTag(t: String): Data595 = copy(tags = t :: tags)
  def put(k: String, v: String): Data595 = copy(meta = meta.updated(k, v))
  def merge(other: Data595): Data595 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data595 {
  given Ordering[Data595] = Ordering.by(_.id)
  def empty: Data595 = Data595(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data595 =
    Data595(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data595] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
