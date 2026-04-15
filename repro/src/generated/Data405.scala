package generated

final case class Data405(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data405 = copy(name = name.toUpperCase)
  def scale(k: Double): Data405 = copy(value = value * k)
  def addTag(t: String): Data405 = copy(tags = t :: tags)
  def put(k: String, v: String): Data405 = copy(meta = meta.updated(k, v))
  def merge(other: Data405): Data405 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data405 {
  given Ordering[Data405] = Ordering.by(_.id)
  def empty: Data405 = Data405(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data405 =
    Data405(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data405] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
