package generated

final case class Data130(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data130 = copy(name = name.toUpperCase)
  def scale(k: Double): Data130 = copy(value = value * k)
  def addTag(t: String): Data130 = copy(tags = t :: tags)
  def put(k: String, v: String): Data130 = copy(meta = meta.updated(k, v))
  def merge(other: Data130): Data130 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data130 {
  given Ordering[Data130] = Ordering.by(_.id)
  def empty: Data130 = Data130(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data130 =
    Data130(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data130] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
