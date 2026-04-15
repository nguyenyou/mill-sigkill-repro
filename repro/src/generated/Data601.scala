package generated

final case class Data601(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data601 = copy(name = name.toUpperCase)
  def scale(k: Double): Data601 = copy(value = value * k)
  def addTag(t: String): Data601 = copy(tags = t :: tags)
  def put(k: String, v: String): Data601 = copy(meta = meta.updated(k, v))
  def merge(other: Data601): Data601 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data601 {
  given Ordering[Data601] = Ordering.by(_.id)
  def empty: Data601 = Data601(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data601 =
    Data601(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data601] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
