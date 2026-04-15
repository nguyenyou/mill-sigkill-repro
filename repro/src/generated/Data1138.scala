package generated

final case class Data1138(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1138 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1138 = copy(value = value * k)
  def addTag(t: String): Data1138 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1138 = copy(meta = meta.updated(k, v))
  def merge(other: Data1138): Data1138 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1138 {
  given Ordering[Data1138] = Ordering.by(_.id)
  def empty: Data1138 = Data1138(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1138 =
    Data1138(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1138] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
