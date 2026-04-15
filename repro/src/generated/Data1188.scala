package generated

final case class Data1188(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1188 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1188 = copy(value = value * k)
  def addTag(t: String): Data1188 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1188 = copy(meta = meta.updated(k, v))
  def merge(other: Data1188): Data1188 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1188 {
  given Ordering[Data1188] = Ordering.by(_.id)
  def empty: Data1188 = Data1188(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1188 =
    Data1188(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1188] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
