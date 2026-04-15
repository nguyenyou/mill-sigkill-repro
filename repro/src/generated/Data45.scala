package generated

final case class Data45(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data45 = copy(name = name.toUpperCase)
  def scale(k: Double): Data45 = copy(value = value * k)
  def addTag(t: String): Data45 = copy(tags = t :: tags)
  def put(k: String, v: String): Data45 = copy(meta = meta.updated(k, v))
  def merge(other: Data45): Data45 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data45 {
  given Ordering[Data45] = Ordering.by(_.id)
  def empty: Data45 = Data45(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data45 =
    Data45(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data45] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
