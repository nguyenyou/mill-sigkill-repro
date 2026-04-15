package generated

final case class Data91(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data91 = copy(name = name.toUpperCase)
  def scale(k: Double): Data91 = copy(value = value * k)
  def addTag(t: String): Data91 = copy(tags = t :: tags)
  def put(k: String, v: String): Data91 = copy(meta = meta.updated(k, v))
  def merge(other: Data91): Data91 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data91 {
  given Ordering[Data91] = Ordering.by(_.id)
  def empty: Data91 = Data91(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data91 =
    Data91(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data91] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
