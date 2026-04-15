package generated

final case class Data878(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data878 = copy(name = name.toUpperCase)
  def scale(k: Double): Data878 = copy(value = value * k)
  def addTag(t: String): Data878 = copy(tags = t :: tags)
  def put(k: String, v: String): Data878 = copy(meta = meta.updated(k, v))
  def merge(other: Data878): Data878 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data878 {
  given Ordering[Data878] = Ordering.by(_.id)
  def empty: Data878 = Data878(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data878 =
    Data878(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data878] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
