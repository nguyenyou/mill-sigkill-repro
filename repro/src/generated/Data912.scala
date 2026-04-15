package generated

final case class Data912(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data912 = copy(name = name.toUpperCase)
  def scale(k: Double): Data912 = copy(value = value * k)
  def addTag(t: String): Data912 = copy(tags = t :: tags)
  def put(k: String, v: String): Data912 = copy(meta = meta.updated(k, v))
  def merge(other: Data912): Data912 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data912 {
  given Ordering[Data912] = Ordering.by(_.id)
  def empty: Data912 = Data912(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data912 =
    Data912(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data912] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
