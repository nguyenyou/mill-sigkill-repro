package generated

final case class Data209(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data209 = copy(name = name.toUpperCase)
  def scale(k: Double): Data209 = copy(value = value * k)
  def addTag(t: String): Data209 = copy(tags = t :: tags)
  def put(k: String, v: String): Data209 = copy(meta = meta.updated(k, v))
  def merge(other: Data209): Data209 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data209 {
  given Ordering[Data209] = Ordering.by(_.id)
  def empty: Data209 = Data209(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data209 =
    Data209(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data209] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
