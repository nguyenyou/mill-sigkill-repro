package generated

final case class Data180(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data180 = copy(name = name.toUpperCase)
  def scale(k: Double): Data180 = copy(value = value * k)
  def addTag(t: String): Data180 = copy(tags = t :: tags)
  def put(k: String, v: String): Data180 = copy(meta = meta.updated(k, v))
  def merge(other: Data180): Data180 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data180 {
  given Ordering[Data180] = Ordering.by(_.id)
  def empty: Data180 = Data180(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data180 =
    Data180(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data180] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
