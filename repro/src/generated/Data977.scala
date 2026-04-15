package generated

final case class Data977(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data977 = copy(name = name.toUpperCase)
  def scale(k: Double): Data977 = copy(value = value * k)
  def addTag(t: String): Data977 = copy(tags = t :: tags)
  def put(k: String, v: String): Data977 = copy(meta = meta.updated(k, v))
  def merge(other: Data977): Data977 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data977 {
  given Ordering[Data977] = Ordering.by(_.id)
  def empty: Data977 = Data977(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data977 =
    Data977(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data977] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
