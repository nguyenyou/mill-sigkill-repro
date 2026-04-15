package generated

final case class Data1123(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1123 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1123 = copy(value = value * k)
  def addTag(t: String): Data1123 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1123 = copy(meta = meta.updated(k, v))
  def merge(other: Data1123): Data1123 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1123 {
  given Ordering[Data1123] = Ordering.by(_.id)
  def empty: Data1123 = Data1123(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1123 =
    Data1123(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1123] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
