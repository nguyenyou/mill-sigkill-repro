package generated

final case class Data365(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data365 = copy(name = name.toUpperCase)
  def scale(k: Double): Data365 = copy(value = value * k)
  def addTag(t: String): Data365 = copy(tags = t :: tags)
  def put(k: String, v: String): Data365 = copy(meta = meta.updated(k, v))
  def merge(other: Data365): Data365 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data365 {
  given Ordering[Data365] = Ordering.by(_.id)
  def empty: Data365 = Data365(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data365 =
    Data365(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data365] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
