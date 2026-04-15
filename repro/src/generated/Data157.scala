package generated

final case class Data157(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data157 = copy(name = name.toUpperCase)
  def scale(k: Double): Data157 = copy(value = value * k)
  def addTag(t: String): Data157 = copy(tags = t :: tags)
  def put(k: String, v: String): Data157 = copy(meta = meta.updated(k, v))
  def merge(other: Data157): Data157 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data157 {
  given Ordering[Data157] = Ordering.by(_.id)
  def empty: Data157 = Data157(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data157 =
    Data157(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data157] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
