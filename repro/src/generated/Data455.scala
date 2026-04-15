package generated

final case class Data455(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data455 = copy(name = name.toUpperCase)
  def scale(k: Double): Data455 = copy(value = value * k)
  def addTag(t: String): Data455 = copy(tags = t :: tags)
  def put(k: String, v: String): Data455 = copy(meta = meta.updated(k, v))
  def merge(other: Data455): Data455 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data455 {
  given Ordering[Data455] = Ordering.by(_.id)
  def empty: Data455 = Data455(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data455 =
    Data455(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data455] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
