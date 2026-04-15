package generated

final case class Data1297(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1297 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1297 = copy(value = value * k)
  def addTag(t: String): Data1297 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1297 = copy(meta = meta.updated(k, v))
  def merge(other: Data1297): Data1297 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1297 {
  given Ordering[Data1297] = Ordering.by(_.id)
  def empty: Data1297 = Data1297(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1297 =
    Data1297(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1297] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
