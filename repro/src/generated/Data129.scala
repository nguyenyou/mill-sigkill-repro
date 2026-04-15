package generated

final case class Data129(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data129 = copy(name = name.toUpperCase)
  def scale(k: Double): Data129 = copy(value = value * k)
  def addTag(t: String): Data129 = copy(tags = t :: tags)
  def put(k: String, v: String): Data129 = copy(meta = meta.updated(k, v))
  def merge(other: Data129): Data129 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data129 {
  given Ordering[Data129] = Ordering.by(_.id)
  def empty: Data129 = Data129(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data129 =
    Data129(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data129] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
