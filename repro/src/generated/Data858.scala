package generated

final case class Data858(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data858 = copy(name = name.toUpperCase)
  def scale(k: Double): Data858 = copy(value = value * k)
  def addTag(t: String): Data858 = copy(tags = t :: tags)
  def put(k: String, v: String): Data858 = copy(meta = meta.updated(k, v))
  def merge(other: Data858): Data858 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data858 {
  given Ordering[Data858] = Ordering.by(_.id)
  def empty: Data858 = Data858(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data858 =
    Data858(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data858] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
