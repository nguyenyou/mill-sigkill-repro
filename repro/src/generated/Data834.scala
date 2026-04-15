package generated

final case class Data834(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data834 = copy(name = name.toUpperCase)
  def scale(k: Double): Data834 = copy(value = value * k)
  def addTag(t: String): Data834 = copy(tags = t :: tags)
  def put(k: String, v: String): Data834 = copy(meta = meta.updated(k, v))
  def merge(other: Data834): Data834 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data834 {
  given Ordering[Data834] = Ordering.by(_.id)
  def empty: Data834 = Data834(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data834 =
    Data834(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data834] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
