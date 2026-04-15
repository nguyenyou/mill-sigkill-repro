package generated

final case class Data1261(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1261 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1261 = copy(value = value * k)
  def addTag(t: String): Data1261 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1261 = copy(meta = meta.updated(k, v))
  def merge(other: Data1261): Data1261 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1261 {
  given Ordering[Data1261] = Ordering.by(_.id)
  def empty: Data1261 = Data1261(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1261 =
    Data1261(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1261] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
