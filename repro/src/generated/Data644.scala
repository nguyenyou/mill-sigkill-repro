package generated

final case class Data644(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data644 = copy(name = name.toUpperCase)
  def scale(k: Double): Data644 = copy(value = value * k)
  def addTag(t: String): Data644 = copy(tags = t :: tags)
  def put(k: String, v: String): Data644 = copy(meta = meta.updated(k, v))
  def merge(other: Data644): Data644 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data644 {
  given Ordering[Data644] = Ordering.by(_.id)
  def empty: Data644 = Data644(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data644 =
    Data644(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data644] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
