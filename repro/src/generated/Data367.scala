package generated

final case class Data367(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data367 = copy(name = name.toUpperCase)
  def scale(k: Double): Data367 = copy(value = value * k)
  def addTag(t: String): Data367 = copy(tags = t :: tags)
  def put(k: String, v: String): Data367 = copy(meta = meta.updated(k, v))
  def merge(other: Data367): Data367 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data367 {
  given Ordering[Data367] = Ordering.by(_.id)
  def empty: Data367 = Data367(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data367 =
    Data367(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data367] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
