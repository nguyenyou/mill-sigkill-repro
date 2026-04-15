package generated

final case class Data1091(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1091 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1091 = copy(value = value * k)
  def addTag(t: String): Data1091 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1091 = copy(meta = meta.updated(k, v))
  def merge(other: Data1091): Data1091 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1091 {
  given Ordering[Data1091] = Ordering.by(_.id)
  def empty: Data1091 = Data1091(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1091 =
    Data1091(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1091] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
