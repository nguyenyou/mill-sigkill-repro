package generated

final case class Data379(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data379 = copy(name = name.toUpperCase)
  def scale(k: Double): Data379 = copy(value = value * k)
  def addTag(t: String): Data379 = copy(tags = t :: tags)
  def put(k: String, v: String): Data379 = copy(meta = meta.updated(k, v))
  def merge(other: Data379): Data379 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data379 {
  given Ordering[Data379] = Ordering.by(_.id)
  def empty: Data379 = Data379(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data379 =
    Data379(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data379] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
