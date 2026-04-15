package generated

final case class Data16(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data16 = copy(name = name.toUpperCase)
  def scale(k: Double): Data16 = copy(value = value * k)
  def addTag(t: String): Data16 = copy(tags = t :: tags)
  def put(k: String, v: String): Data16 = copy(meta = meta.updated(k, v))
  def merge(other: Data16): Data16 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data16 {
  given Ordering[Data16] = Ordering.by(_.id)
  def empty: Data16 = Data16(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data16 =
    Data16(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data16] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
