package generated

final case class Data529(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data529 = copy(name = name.toUpperCase)
  def scale(k: Double): Data529 = copy(value = value * k)
  def addTag(t: String): Data529 = copy(tags = t :: tags)
  def put(k: String, v: String): Data529 = copy(meta = meta.updated(k, v))
  def merge(other: Data529): Data529 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data529 {
  given Ordering[Data529] = Ordering.by(_.id)
  def empty: Data529 = Data529(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data529 =
    Data529(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data529] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
