package generated

final case class Data253(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data253 = copy(name = name.toUpperCase)
  def scale(k: Double): Data253 = copy(value = value * k)
  def addTag(t: String): Data253 = copy(tags = t :: tags)
  def put(k: String, v: String): Data253 = copy(meta = meta.updated(k, v))
  def merge(other: Data253): Data253 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data253 {
  given Ordering[Data253] = Ordering.by(_.id)
  def empty: Data253 = Data253(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data253 =
    Data253(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data253] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
