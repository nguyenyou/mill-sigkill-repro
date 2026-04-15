package generated

final case class Data257(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data257 = copy(name = name.toUpperCase)
  def scale(k: Double): Data257 = copy(value = value * k)
  def addTag(t: String): Data257 = copy(tags = t :: tags)
  def put(k: String, v: String): Data257 = copy(meta = meta.updated(k, v))
  def merge(other: Data257): Data257 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data257 {
  given Ordering[Data257] = Ordering.by(_.id)
  def empty: Data257 = Data257(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data257 =
    Data257(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data257] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
