package generated

final case class Data346(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data346 = copy(name = name.toUpperCase)
  def scale(k: Double): Data346 = copy(value = value * k)
  def addTag(t: String): Data346 = copy(tags = t :: tags)
  def put(k: String, v: String): Data346 = copy(meta = meta.updated(k, v))
  def merge(other: Data346): Data346 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data346 {
  given Ordering[Data346] = Ordering.by(_.id)
  def empty: Data346 = Data346(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data346 =
    Data346(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data346] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
