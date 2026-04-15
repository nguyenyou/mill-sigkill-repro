package generated

final case class Data1081(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1081 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1081 = copy(value = value * k)
  def addTag(t: String): Data1081 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1081 = copy(meta = meta.updated(k, v))
  def merge(other: Data1081): Data1081 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1081 {
  given Ordering[Data1081] = Ordering.by(_.id)
  def empty: Data1081 = Data1081(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1081 =
    Data1081(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1081] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
