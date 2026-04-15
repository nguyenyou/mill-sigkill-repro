package generated

final case class Data426(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data426 = copy(name = name.toUpperCase)
  def scale(k: Double): Data426 = copy(value = value * k)
  def addTag(t: String): Data426 = copy(tags = t :: tags)
  def put(k: String, v: String): Data426 = copy(meta = meta.updated(k, v))
  def merge(other: Data426): Data426 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data426 {
  given Ordering[Data426] = Ordering.by(_.id)
  def empty: Data426 = Data426(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data426 =
    Data426(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data426] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
