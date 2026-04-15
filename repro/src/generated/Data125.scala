package generated

final case class Data125(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data125 = copy(name = name.toUpperCase)
  def scale(k: Double): Data125 = copy(value = value * k)
  def addTag(t: String): Data125 = copy(tags = t :: tags)
  def put(k: String, v: String): Data125 = copy(meta = meta.updated(k, v))
  def merge(other: Data125): Data125 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data125 {
  given Ordering[Data125] = Ordering.by(_.id)
  def empty: Data125 = Data125(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data125 =
    Data125(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data125] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
