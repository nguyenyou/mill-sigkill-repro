package generated

final case class Data1136(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1136 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1136 = copy(value = value * k)
  def addTag(t: String): Data1136 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1136 = copy(meta = meta.updated(k, v))
  def merge(other: Data1136): Data1136 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1136 {
  given Ordering[Data1136] = Ordering.by(_.id)
  def empty: Data1136 = Data1136(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1136 =
    Data1136(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1136] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
