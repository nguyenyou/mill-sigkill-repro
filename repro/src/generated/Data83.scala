package generated

final case class Data83(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data83 = copy(name = name.toUpperCase)
  def scale(k: Double): Data83 = copy(value = value * k)
  def addTag(t: String): Data83 = copy(tags = t :: tags)
  def put(k: String, v: String): Data83 = copy(meta = meta.updated(k, v))
  def merge(other: Data83): Data83 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data83 {
  given Ordering[Data83] = Ordering.by(_.id)
  def empty: Data83 = Data83(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data83 =
    Data83(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data83] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
