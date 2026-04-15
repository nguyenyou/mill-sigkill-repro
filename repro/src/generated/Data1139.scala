package generated

final case class Data1139(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1139 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1139 = copy(value = value * k)
  def addTag(t: String): Data1139 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1139 = copy(meta = meta.updated(k, v))
  def merge(other: Data1139): Data1139 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1139 {
  given Ordering[Data1139] = Ordering.by(_.id)
  def empty: Data1139 = Data1139(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1139 =
    Data1139(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1139] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
