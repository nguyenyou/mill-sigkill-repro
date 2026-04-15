package generated

final case class Data1106(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1106 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1106 = copy(value = value * k)
  def addTag(t: String): Data1106 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1106 = copy(meta = meta.updated(k, v))
  def merge(other: Data1106): Data1106 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1106 {
  given Ordering[Data1106] = Ordering.by(_.id)
  def empty: Data1106 = Data1106(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1106 =
    Data1106(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1106] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
