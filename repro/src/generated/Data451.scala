package generated

final case class Data451(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data451 = copy(name = name.toUpperCase)
  def scale(k: Double): Data451 = copy(value = value * k)
  def addTag(t: String): Data451 = copy(tags = t :: tags)
  def put(k: String, v: String): Data451 = copy(meta = meta.updated(k, v))
  def merge(other: Data451): Data451 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data451 {
  given Ordering[Data451] = Ordering.by(_.id)
  def empty: Data451 = Data451(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data451 =
    Data451(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data451] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
