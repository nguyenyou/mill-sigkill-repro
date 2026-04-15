package generated

final case class Data536(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data536 = copy(name = name.toUpperCase)
  def scale(k: Double): Data536 = copy(value = value * k)
  def addTag(t: String): Data536 = copy(tags = t :: tags)
  def put(k: String, v: String): Data536 = copy(meta = meta.updated(k, v))
  def merge(other: Data536): Data536 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data536 {
  given Ordering[Data536] = Ordering.by(_.id)
  def empty: Data536 = Data536(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data536 =
    Data536(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data536] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
