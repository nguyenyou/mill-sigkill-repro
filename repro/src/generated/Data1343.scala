package generated

final case class Data1343(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1343 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1343 = copy(value = value * k)
  def addTag(t: String): Data1343 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1343 = copy(meta = meta.updated(k, v))
  def merge(other: Data1343): Data1343 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1343 {
  given Ordering[Data1343] = Ordering.by(_.id)
  def empty: Data1343 = Data1343(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1343 =
    Data1343(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1343] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
