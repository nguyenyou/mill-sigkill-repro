package generated

final case class Data746(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data746 = copy(name = name.toUpperCase)
  def scale(k: Double): Data746 = copy(value = value * k)
  def addTag(t: String): Data746 = copy(tags = t :: tags)
  def put(k: String, v: String): Data746 = copy(meta = meta.updated(k, v))
  def merge(other: Data746): Data746 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data746 {
  given Ordering[Data746] = Ordering.by(_.id)
  def empty: Data746 = Data746(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data746 =
    Data746(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data746] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
