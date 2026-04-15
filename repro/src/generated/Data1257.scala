package generated

final case class Data1257(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1257 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1257 = copy(value = value * k)
  def addTag(t: String): Data1257 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1257 = copy(meta = meta.updated(k, v))
  def merge(other: Data1257): Data1257 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1257 {
  given Ordering[Data1257] = Ordering.by(_.id)
  def empty: Data1257 = Data1257(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1257 =
    Data1257(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1257] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
