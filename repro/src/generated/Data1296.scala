package generated

final case class Data1296(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1296 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1296 = copy(value = value * k)
  def addTag(t: String): Data1296 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1296 = copy(meta = meta.updated(k, v))
  def merge(other: Data1296): Data1296 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1296 {
  given Ordering[Data1296] = Ordering.by(_.id)
  def empty: Data1296 = Data1296(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1296 =
    Data1296(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1296] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
