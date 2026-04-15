package generated

final case class Data44(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data44 = copy(name = name.toUpperCase)
  def scale(k: Double): Data44 = copy(value = value * k)
  def addTag(t: String): Data44 = copy(tags = t :: tags)
  def put(k: String, v: String): Data44 = copy(meta = meta.updated(k, v))
  def merge(other: Data44): Data44 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data44 {
  given Ordering[Data44] = Ordering.by(_.id)
  def empty: Data44 = Data44(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data44 =
    Data44(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data44] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
