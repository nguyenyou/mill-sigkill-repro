package generated

final case class Data270(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data270 = copy(name = name.toUpperCase)
  def scale(k: Double): Data270 = copy(value = value * k)
  def addTag(t: String): Data270 = copy(tags = t :: tags)
  def put(k: String, v: String): Data270 = copy(meta = meta.updated(k, v))
  def merge(other: Data270): Data270 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data270 {
  given Ordering[Data270] = Ordering.by(_.id)
  def empty: Data270 = Data270(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data270 =
    Data270(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data270] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
