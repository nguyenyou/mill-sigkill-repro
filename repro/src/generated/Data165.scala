package generated

final case class Data165(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data165 = copy(name = name.toUpperCase)
  def scale(k: Double): Data165 = copy(value = value * k)
  def addTag(t: String): Data165 = copy(tags = t :: tags)
  def put(k: String, v: String): Data165 = copy(meta = meta.updated(k, v))
  def merge(other: Data165): Data165 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data165 {
  given Ordering[Data165] = Ordering.by(_.id)
  def empty: Data165 = Data165(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data165 =
    Data165(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data165] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
