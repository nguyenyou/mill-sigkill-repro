package generated

final case class Data643(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data643 = copy(name = name.toUpperCase)
  def scale(k: Double): Data643 = copy(value = value * k)
  def addTag(t: String): Data643 = copy(tags = t :: tags)
  def put(k: String, v: String): Data643 = copy(meta = meta.updated(k, v))
  def merge(other: Data643): Data643 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data643 {
  given Ordering[Data643] = Ordering.by(_.id)
  def empty: Data643 = Data643(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data643 =
    Data643(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data643] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
