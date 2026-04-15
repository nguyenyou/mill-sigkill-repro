package generated

final case class Data210(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data210 = copy(name = name.toUpperCase)
  def scale(k: Double): Data210 = copy(value = value * k)
  def addTag(t: String): Data210 = copy(tags = t :: tags)
  def put(k: String, v: String): Data210 = copy(meta = meta.updated(k, v))
  def merge(other: Data210): Data210 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data210 {
  given Ordering[Data210] = Ordering.by(_.id)
  def empty: Data210 = Data210(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data210 =
    Data210(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data210] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
