package generated

final case class Data919(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data919 = copy(name = name.toUpperCase)
  def scale(k: Double): Data919 = copy(value = value * k)
  def addTag(t: String): Data919 = copy(tags = t :: tags)
  def put(k: String, v: String): Data919 = copy(meta = meta.updated(k, v))
  def merge(other: Data919): Data919 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data919 {
  given Ordering[Data919] = Ordering.by(_.id)
  def empty: Data919 = Data919(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data919 =
    Data919(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data919] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
