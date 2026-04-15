package generated

final case class Data1336(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1336 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1336 = copy(value = value * k)
  def addTag(t: String): Data1336 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1336 = copy(meta = meta.updated(k, v))
  def merge(other: Data1336): Data1336 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1336 {
  given Ordering[Data1336] = Ordering.by(_.id)
  def empty: Data1336 = Data1336(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1336 =
    Data1336(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1336] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
