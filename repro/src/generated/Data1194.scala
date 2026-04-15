package generated

final case class Data1194(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1194 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1194 = copy(value = value * k)
  def addTag(t: String): Data1194 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1194 = copy(meta = meta.updated(k, v))
  def merge(other: Data1194): Data1194 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1194 {
  given Ordering[Data1194] = Ordering.by(_.id)
  def empty: Data1194 = Data1194(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1194 =
    Data1194(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1194] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
