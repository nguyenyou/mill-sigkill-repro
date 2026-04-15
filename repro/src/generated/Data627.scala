package generated

final case class Data627(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data627 = copy(name = name.toUpperCase)
  def scale(k: Double): Data627 = copy(value = value * k)
  def addTag(t: String): Data627 = copy(tags = t :: tags)
  def put(k: String, v: String): Data627 = copy(meta = meta.updated(k, v))
  def merge(other: Data627): Data627 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data627 {
  given Ordering[Data627] = Ordering.by(_.id)
  def empty: Data627 = Data627(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data627 =
    Data627(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data627] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
