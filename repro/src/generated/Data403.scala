package generated

final case class Data403(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data403 = copy(name = name.toUpperCase)
  def scale(k: Double): Data403 = copy(value = value * k)
  def addTag(t: String): Data403 = copy(tags = t :: tags)
  def put(k: String, v: String): Data403 = copy(meta = meta.updated(k, v))
  def merge(other: Data403): Data403 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data403 {
  given Ordering[Data403] = Ordering.by(_.id)
  def empty: Data403 = Data403(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data403 =
    Data403(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data403] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
