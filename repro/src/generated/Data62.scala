package generated

final case class Data62(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data62 = copy(name = name.toUpperCase)
  def scale(k: Double): Data62 = copy(value = value * k)
  def addTag(t: String): Data62 = copy(tags = t :: tags)
  def put(k: String, v: String): Data62 = copy(meta = meta.updated(k, v))
  def merge(other: Data62): Data62 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data62 {
  given Ordering[Data62] = Ordering.by(_.id)
  def empty: Data62 = Data62(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data62 =
    Data62(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data62] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
