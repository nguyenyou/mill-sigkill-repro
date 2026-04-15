package generated

final case class Data655(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data655 = copy(name = name.toUpperCase)
  def scale(k: Double): Data655 = copy(value = value * k)
  def addTag(t: String): Data655 = copy(tags = t :: tags)
  def put(k: String, v: String): Data655 = copy(meta = meta.updated(k, v))
  def merge(other: Data655): Data655 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data655 {
  given Ordering[Data655] = Ordering.by(_.id)
  def empty: Data655 = Data655(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data655 =
    Data655(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data655] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
