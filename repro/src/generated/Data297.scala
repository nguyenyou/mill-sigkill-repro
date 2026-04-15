package generated

final case class Data297(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data297 = copy(name = name.toUpperCase)
  def scale(k: Double): Data297 = copy(value = value * k)
  def addTag(t: String): Data297 = copy(tags = t :: tags)
  def put(k: String, v: String): Data297 = copy(meta = meta.updated(k, v))
  def merge(other: Data297): Data297 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data297 {
  given Ordering[Data297] = Ordering.by(_.id)
  def empty: Data297 = Data297(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data297 =
    Data297(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data297] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
