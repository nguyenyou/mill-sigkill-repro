package generated

final case class Data1065(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1065 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1065 = copy(value = value * k)
  def addTag(t: String): Data1065 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1065 = copy(meta = meta.updated(k, v))
  def merge(other: Data1065): Data1065 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1065 {
  given Ordering[Data1065] = Ordering.by(_.id)
  def empty: Data1065 = Data1065(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1065 =
    Data1065(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1065] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
