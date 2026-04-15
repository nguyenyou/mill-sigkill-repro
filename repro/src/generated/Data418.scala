package generated

final case class Data418(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data418 = copy(name = name.toUpperCase)
  def scale(k: Double): Data418 = copy(value = value * k)
  def addTag(t: String): Data418 = copy(tags = t :: tags)
  def put(k: String, v: String): Data418 = copy(meta = meta.updated(k, v))
  def merge(other: Data418): Data418 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data418 {
  given Ordering[Data418] = Ordering.by(_.id)
  def empty: Data418 = Data418(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data418 =
    Data418(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data418] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
