package generated

final case class Data343(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data343 = copy(name = name.toUpperCase)
  def scale(k: Double): Data343 = copy(value = value * k)
  def addTag(t: String): Data343 = copy(tags = t :: tags)
  def put(k: String, v: String): Data343 = copy(meta = meta.updated(k, v))
  def merge(other: Data343): Data343 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data343 {
  given Ordering[Data343] = Ordering.by(_.id)
  def empty: Data343 = Data343(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data343 =
    Data343(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data343] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
