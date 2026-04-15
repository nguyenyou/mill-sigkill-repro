package generated

final case class Data249(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data249 = copy(name = name.toUpperCase)
  def scale(k: Double): Data249 = copy(value = value * k)
  def addTag(t: String): Data249 = copy(tags = t :: tags)
  def put(k: String, v: String): Data249 = copy(meta = meta.updated(k, v))
  def merge(other: Data249): Data249 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data249 {
  given Ordering[Data249] = Ordering.by(_.id)
  def empty: Data249 = Data249(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data249 =
    Data249(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data249] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
