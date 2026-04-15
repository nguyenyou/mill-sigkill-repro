package generated

final case class Data970(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data970 = copy(name = name.toUpperCase)
  def scale(k: Double): Data970 = copy(value = value * k)
  def addTag(t: String): Data970 = copy(tags = t :: tags)
  def put(k: String, v: String): Data970 = copy(meta = meta.updated(k, v))
  def merge(other: Data970): Data970 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data970 {
  given Ordering[Data970] = Ordering.by(_.id)
  def empty: Data970 = Data970(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data970 =
    Data970(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data970] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
