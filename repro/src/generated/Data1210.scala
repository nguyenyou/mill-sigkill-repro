package generated

final case class Data1210(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1210 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1210 = copy(value = value * k)
  def addTag(t: String): Data1210 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1210 = copy(meta = meta.updated(k, v))
  def merge(other: Data1210): Data1210 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1210 {
  given Ordering[Data1210] = Ordering.by(_.id)
  def empty: Data1210 = Data1210(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1210 =
    Data1210(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1210] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
