package generated

final case class Data1116(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1116 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1116 = copy(value = value * k)
  def addTag(t: String): Data1116 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1116 = copy(meta = meta.updated(k, v))
  def merge(other: Data1116): Data1116 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1116 {
  given Ordering[Data1116] = Ordering.by(_.id)
  def empty: Data1116 = Data1116(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1116 =
    Data1116(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1116] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
