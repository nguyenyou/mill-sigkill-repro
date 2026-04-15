package generated

final case class Data631(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data631 = copy(name = name.toUpperCase)
  def scale(k: Double): Data631 = copy(value = value * k)
  def addTag(t: String): Data631 = copy(tags = t :: tags)
  def put(k: String, v: String): Data631 = copy(meta = meta.updated(k, v))
  def merge(other: Data631): Data631 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data631 {
  given Ordering[Data631] = Ordering.by(_.id)
  def empty: Data631 = Data631(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data631 =
    Data631(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data631] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
