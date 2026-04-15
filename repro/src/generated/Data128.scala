package generated

final case class Data128(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data128 = copy(name = name.toUpperCase)
  def scale(k: Double): Data128 = copy(value = value * k)
  def addTag(t: String): Data128 = copy(tags = t :: tags)
  def put(k: String, v: String): Data128 = copy(meta = meta.updated(k, v))
  def merge(other: Data128): Data128 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data128 {
  given Ordering[Data128] = Ordering.by(_.id)
  def empty: Data128 = Data128(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data128 =
    Data128(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data128] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
