package generated

final case class Data247(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data247 = copy(name = name.toUpperCase)
  def scale(k: Double): Data247 = copy(value = value * k)
  def addTag(t: String): Data247 = copy(tags = t :: tags)
  def put(k: String, v: String): Data247 = copy(meta = meta.updated(k, v))
  def merge(other: Data247): Data247 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data247 {
  given Ordering[Data247] = Ordering.by(_.id)
  def empty: Data247 = Data247(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data247 =
    Data247(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data247] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
