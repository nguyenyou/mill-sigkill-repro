package generated
// probe-edit-4

final case class Data4(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data4 = copy(name = name.toUpperCase)
  def scale(k: Double): Data4 = copy(value = value * k)
  def addTag(t: String): Data4 = copy(tags = t :: tags)
  def put(k: String, v: String): Data4 = copy(meta = meta.updated(k, v))
  def merge(other: Data4): Data4 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data4 {
  given Ordering[Data4] = Ordering.by(_.id)
  def empty: Data4 = Data4(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data4 =
    Data4(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data4] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
