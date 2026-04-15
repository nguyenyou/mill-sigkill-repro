package generated

final case class Data524(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data524 = copy(name = name.toUpperCase)
  def scale(k: Double): Data524 = copy(value = value * k)
  def addTag(t: String): Data524 = copy(tags = t :: tags)
  def put(k: String, v: String): Data524 = copy(meta = meta.updated(k, v))
  def merge(other: Data524): Data524 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data524 {
  given Ordering[Data524] = Ordering.by(_.id)
  def empty: Data524 = Data524(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data524 =
    Data524(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data524] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
