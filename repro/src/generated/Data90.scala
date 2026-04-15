package generated

final case class Data90(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data90 = copy(name = name.toUpperCase)
  def scale(k: Double): Data90 = copy(value = value * k)
  def addTag(t: String): Data90 = copy(tags = t :: tags)
  def put(k: String, v: String): Data90 = copy(meta = meta.updated(k, v))
  def merge(other: Data90): Data90 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data90 {
  given Ordering[Data90] = Ordering.by(_.id)
  def empty: Data90 = Data90(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data90 =
    Data90(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data90] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
