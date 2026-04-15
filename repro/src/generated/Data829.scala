package generated

final case class Data829(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data829 = copy(name = name.toUpperCase)
  def scale(k: Double): Data829 = copy(value = value * k)
  def addTag(t: String): Data829 = copy(tags = t :: tags)
  def put(k: String, v: String): Data829 = copy(meta = meta.updated(k, v))
  def merge(other: Data829): Data829 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data829 {
  given Ordering[Data829] = Ordering.by(_.id)
  def empty: Data829 = Data829(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data829 =
    Data829(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data829] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
