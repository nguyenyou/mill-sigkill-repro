package generated

final case class Data1327(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1327 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1327 = copy(value = value * k)
  def addTag(t: String): Data1327 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1327 = copy(meta = meta.updated(k, v))
  def merge(other: Data1327): Data1327 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1327 {
  given Ordering[Data1327] = Ordering.by(_.id)
  def empty: Data1327 = Data1327(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1327 =
    Data1327(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1327] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
