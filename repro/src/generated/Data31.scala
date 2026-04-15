package generated

final case class Data31(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data31 = copy(name = name.toUpperCase)
  def scale(k: Double): Data31 = copy(value = value * k)
  def addTag(t: String): Data31 = copy(tags = t :: tags)
  def put(k: String, v: String): Data31 = copy(meta = meta.updated(k, v))
  def merge(other: Data31): Data31 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data31 {
  given Ordering[Data31] = Ordering.by(_.id)
  def empty: Data31 = Data31(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data31 =
    Data31(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data31] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
