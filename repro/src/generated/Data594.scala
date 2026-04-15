package generated

final case class Data594(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data594 = copy(name = name.toUpperCase)
  def scale(k: Double): Data594 = copy(value = value * k)
  def addTag(t: String): Data594 = copy(tags = t :: tags)
  def put(k: String, v: String): Data594 = copy(meta = meta.updated(k, v))
  def merge(other: Data594): Data594 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data594 {
  given Ordering[Data594] = Ordering.by(_.id)
  def empty: Data594 = Data594(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data594 =
    Data594(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data594] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
