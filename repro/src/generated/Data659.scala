package generated

final case class Data659(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data659 = copy(name = name.toUpperCase)
  def scale(k: Double): Data659 = copy(value = value * k)
  def addTag(t: String): Data659 = copy(tags = t :: tags)
  def put(k: String, v: String): Data659 = copy(meta = meta.updated(k, v))
  def merge(other: Data659): Data659 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data659 {
  given Ordering[Data659] = Ordering.by(_.id)
  def empty: Data659 = Data659(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data659 =
    Data659(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data659] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
