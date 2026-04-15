package generated

final case class Data413(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data413 = copy(name = name.toUpperCase)
  def scale(k: Double): Data413 = copy(value = value * k)
  def addTag(t: String): Data413 = copy(tags = t :: tags)
  def put(k: String, v: String): Data413 = copy(meta = meta.updated(k, v))
  def merge(other: Data413): Data413 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data413 {
  given Ordering[Data413] = Ordering.by(_.id)
  def empty: Data413 = Data413(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data413 =
    Data413(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data413] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
