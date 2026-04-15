package generated

final case class Data774(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data774 = copy(name = name.toUpperCase)
  def scale(k: Double): Data774 = copy(value = value * k)
  def addTag(t: String): Data774 = copy(tags = t :: tags)
  def put(k: String, v: String): Data774 = copy(meta = meta.updated(k, v))
  def merge(other: Data774): Data774 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data774 {
  given Ordering[Data774] = Ordering.by(_.id)
  def empty: Data774 = Data774(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data774 =
    Data774(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data774] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
