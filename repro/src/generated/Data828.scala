package generated

final case class Data828(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data828 = copy(name = name.toUpperCase)
  def scale(k: Double): Data828 = copy(value = value * k)
  def addTag(t: String): Data828 = copy(tags = t :: tags)
  def put(k: String, v: String): Data828 = copy(meta = meta.updated(k, v))
  def merge(other: Data828): Data828 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data828 {
  given Ordering[Data828] = Ordering.by(_.id)
  def empty: Data828 = Data828(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data828 =
    Data828(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data828] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
