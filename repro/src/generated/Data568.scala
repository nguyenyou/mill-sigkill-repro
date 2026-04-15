package generated

final case class Data568(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data568 = copy(name = name.toUpperCase)
  def scale(k: Double): Data568 = copy(value = value * k)
  def addTag(t: String): Data568 = copy(tags = t :: tags)
  def put(k: String, v: String): Data568 = copy(meta = meta.updated(k, v))
  def merge(other: Data568): Data568 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data568 {
  given Ordering[Data568] = Ordering.by(_.id)
  def empty: Data568 = Data568(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data568 =
    Data568(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data568] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
