package generated

final case class Data136(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data136 = copy(name = name.toUpperCase)
  def scale(k: Double): Data136 = copy(value = value * k)
  def addTag(t: String): Data136 = copy(tags = t :: tags)
  def put(k: String, v: String): Data136 = copy(meta = meta.updated(k, v))
  def merge(other: Data136): Data136 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data136 {
  given Ordering[Data136] = Ordering.by(_.id)
  def empty: Data136 = Data136(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data136 =
    Data136(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data136] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
