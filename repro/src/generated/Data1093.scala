package generated

final case class Data1093(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1093 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1093 = copy(value = value * k)
  def addTag(t: String): Data1093 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1093 = copy(meta = meta.updated(k, v))
  def merge(other: Data1093): Data1093 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1093 {
  given Ordering[Data1093] = Ordering.by(_.id)
  def empty: Data1093 = Data1093(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1093 =
    Data1093(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1093] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
