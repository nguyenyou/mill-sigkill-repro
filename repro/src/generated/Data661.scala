package generated

final case class Data661(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data661 = copy(name = name.toUpperCase)
  def scale(k: Double): Data661 = copy(value = value * k)
  def addTag(t: String): Data661 = copy(tags = t :: tags)
  def put(k: String, v: String): Data661 = copy(meta = meta.updated(k, v))
  def merge(other: Data661): Data661 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data661 {
  given Ordering[Data661] = Ordering.by(_.id)
  def empty: Data661 = Data661(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data661 =
    Data661(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data661] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
