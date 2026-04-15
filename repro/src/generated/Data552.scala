package generated

final case class Data552(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data552 = copy(name = name.toUpperCase)
  def scale(k: Double): Data552 = copy(value = value * k)
  def addTag(t: String): Data552 = copy(tags = t :: tags)
  def put(k: String, v: String): Data552 = copy(meta = meta.updated(k, v))
  def merge(other: Data552): Data552 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data552 {
  given Ordering[Data552] = Ordering.by(_.id)
  def empty: Data552 = Data552(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data552 =
    Data552(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data552] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
