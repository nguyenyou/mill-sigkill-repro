package generated

final case class Data637(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data637 = copy(name = name.toUpperCase)
  def scale(k: Double): Data637 = copy(value = value * k)
  def addTag(t: String): Data637 = copy(tags = t :: tags)
  def put(k: String, v: String): Data637 = copy(meta = meta.updated(k, v))
  def merge(other: Data637): Data637 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data637 {
  given Ordering[Data637] = Ordering.by(_.id)
  def empty: Data637 = Data637(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data637 =
    Data637(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data637] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
