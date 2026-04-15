package generated

final case class Data555(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data555 = copy(name = name.toUpperCase)
  def scale(k: Double): Data555 = copy(value = value * k)
  def addTag(t: String): Data555 = copy(tags = t :: tags)
  def put(k: String, v: String): Data555 = copy(meta = meta.updated(k, v))
  def merge(other: Data555): Data555 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data555 {
  given Ordering[Data555] = Ordering.by(_.id)
  def empty: Data555 = Data555(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data555 =
    Data555(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data555] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
