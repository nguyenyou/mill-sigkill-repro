package generated

final case class Data1064(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1064 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1064 = copy(value = value * k)
  def addTag(t: String): Data1064 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1064 = copy(meta = meta.updated(k, v))
  def merge(other: Data1064): Data1064 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1064 {
  given Ordering[Data1064] = Ordering.by(_.id)
  def empty: Data1064 = Data1064(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1064 =
    Data1064(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1064] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
