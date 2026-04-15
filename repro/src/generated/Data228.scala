package generated

final case class Data228(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data228 = copy(name = name.toUpperCase)
  def scale(k: Double): Data228 = copy(value = value * k)
  def addTag(t: String): Data228 = copy(tags = t :: tags)
  def put(k: String, v: String): Data228 = copy(meta = meta.updated(k, v))
  def merge(other: Data228): Data228 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data228 {
  given Ordering[Data228] = Ordering.by(_.id)
  def empty: Data228 = Data228(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data228 =
    Data228(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data228] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
