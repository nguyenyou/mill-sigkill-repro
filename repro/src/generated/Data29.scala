package generated

final case class Data29(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data29 = copy(name = name.toUpperCase)
  def scale(k: Double): Data29 = copy(value = value * k)
  def addTag(t: String): Data29 = copy(tags = t :: tags)
  def put(k: String, v: String): Data29 = copy(meta = meta.updated(k, v))
  def merge(other: Data29): Data29 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data29 {
  given Ordering[Data29] = Ordering.by(_.id)
  def empty: Data29 = Data29(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data29 =
    Data29(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data29] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
