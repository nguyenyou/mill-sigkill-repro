package generated

final case class Data383(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data383 = copy(name = name.toUpperCase)
  def scale(k: Double): Data383 = copy(value = value * k)
  def addTag(t: String): Data383 = copy(tags = t :: tags)
  def put(k: String, v: String): Data383 = copy(meta = meta.updated(k, v))
  def merge(other: Data383): Data383 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data383 {
  given Ordering[Data383] = Ordering.by(_.id)
  def empty: Data383 = Data383(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data383 =
    Data383(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data383] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
