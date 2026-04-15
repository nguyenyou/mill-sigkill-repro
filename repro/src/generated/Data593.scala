package generated

final case class Data593(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data593 = copy(name = name.toUpperCase)
  def scale(k: Double): Data593 = copy(value = value * k)
  def addTag(t: String): Data593 = copy(tags = t :: tags)
  def put(k: String, v: String): Data593 = copy(meta = meta.updated(k, v))
  def merge(other: Data593): Data593 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data593 {
  given Ordering[Data593] = Ordering.by(_.id)
  def empty: Data593 = Data593(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data593 =
    Data593(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data593] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
