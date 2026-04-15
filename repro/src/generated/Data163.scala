package generated

final case class Data163(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data163 = copy(name = name.toUpperCase)
  def scale(k: Double): Data163 = copy(value = value * k)
  def addTag(t: String): Data163 = copy(tags = t :: tags)
  def put(k: String, v: String): Data163 = copy(meta = meta.updated(k, v))
  def merge(other: Data163): Data163 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data163 {
  given Ordering[Data163] = Ordering.by(_.id)
  def empty: Data163 = Data163(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data163 =
    Data163(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data163] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
