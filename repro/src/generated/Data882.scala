package generated

final case class Data882(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data882 = copy(name = name.toUpperCase)
  def scale(k: Double): Data882 = copy(value = value * k)
  def addTag(t: String): Data882 = copy(tags = t :: tags)
  def put(k: String, v: String): Data882 = copy(meta = meta.updated(k, v))
  def merge(other: Data882): Data882 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data882 {
  given Ordering[Data882] = Ordering.by(_.id)
  def empty: Data882 = Data882(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data882 =
    Data882(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data882] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
