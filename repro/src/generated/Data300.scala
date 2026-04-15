package generated

final case class Data300(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data300 = copy(name = name.toUpperCase)
  def scale(k: Double): Data300 = copy(value = value * k)
  def addTag(t: String): Data300 = copy(tags = t :: tags)
  def put(k: String, v: String): Data300 = copy(meta = meta.updated(k, v))
  def merge(other: Data300): Data300 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data300 {
  given Ordering[Data300] = Ordering.by(_.id)
  def empty: Data300 = Data300(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data300 =
    Data300(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data300] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
