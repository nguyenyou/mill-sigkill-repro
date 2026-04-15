package generated

final case class Data605(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data605 = copy(name = name.toUpperCase)
  def scale(k: Double): Data605 = copy(value = value * k)
  def addTag(t: String): Data605 = copy(tags = t :: tags)
  def put(k: String, v: String): Data605 = copy(meta = meta.updated(k, v))
  def merge(other: Data605): Data605 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data605 {
  given Ordering[Data605] = Ordering.by(_.id)
  def empty: Data605 = Data605(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data605 =
    Data605(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data605] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
