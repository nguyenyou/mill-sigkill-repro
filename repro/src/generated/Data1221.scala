package generated

final case class Data1221(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1221 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1221 = copy(value = value * k)
  def addTag(t: String): Data1221 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1221 = copy(meta = meta.updated(k, v))
  def merge(other: Data1221): Data1221 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1221 {
  given Ordering[Data1221] = Ordering.by(_.id)
  def empty: Data1221 = Data1221(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1221 =
    Data1221(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1221] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
