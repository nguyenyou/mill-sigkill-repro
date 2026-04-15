package generated

final case class Data781(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data781 = copy(name = name.toUpperCase)
  def scale(k: Double): Data781 = copy(value = value * k)
  def addTag(t: String): Data781 = copy(tags = t :: tags)
  def put(k: String, v: String): Data781 = copy(meta = meta.updated(k, v))
  def merge(other: Data781): Data781 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data781 {
  given Ordering[Data781] = Ordering.by(_.id)
  def empty: Data781 = Data781(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data781 =
    Data781(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data781] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
