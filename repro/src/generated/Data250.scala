package generated

final case class Data250(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data250 = copy(name = name.toUpperCase)
  def scale(k: Double): Data250 = copy(value = value * k)
  def addTag(t: String): Data250 = copy(tags = t :: tags)
  def put(k: String, v: String): Data250 = copy(meta = meta.updated(k, v))
  def merge(other: Data250): Data250 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data250 {
  given Ordering[Data250] = Ordering.by(_.id)
  def empty: Data250 = Data250(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data250 =
    Data250(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data250] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
