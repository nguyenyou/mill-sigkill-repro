package generated

final case class Data98(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data98 = copy(name = name.toUpperCase)
  def scale(k: Double): Data98 = copy(value = value * k)
  def addTag(t: String): Data98 = copy(tags = t :: tags)
  def put(k: String, v: String): Data98 = copy(meta = meta.updated(k, v))
  def merge(other: Data98): Data98 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data98 {
  given Ordering[Data98] = Ordering.by(_.id)
  def empty: Data98 = Data98(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data98 =
    Data98(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data98] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
