package generated

final case class Data801(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data801 = copy(name = name.toUpperCase)
  def scale(k: Double): Data801 = copy(value = value * k)
  def addTag(t: String): Data801 = copy(tags = t :: tags)
  def put(k: String, v: String): Data801 = copy(meta = meta.updated(k, v))
  def merge(other: Data801): Data801 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data801 {
  given Ordering[Data801] = Ordering.by(_.id)
  def empty: Data801 = Data801(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data801 =
    Data801(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data801] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
