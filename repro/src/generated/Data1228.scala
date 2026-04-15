package generated

final case class Data1228(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1228 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1228 = copy(value = value * k)
  def addTag(t: String): Data1228 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1228 = copy(meta = meta.updated(k, v))
  def merge(other: Data1228): Data1228 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1228 {
  given Ordering[Data1228] = Ordering.by(_.id)
  def empty: Data1228 = Data1228(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1228 =
    Data1228(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1228] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
