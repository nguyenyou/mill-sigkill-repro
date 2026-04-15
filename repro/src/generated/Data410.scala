package generated

final case class Data410(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data410 = copy(name = name.toUpperCase)
  def scale(k: Double): Data410 = copy(value = value * k)
  def addTag(t: String): Data410 = copy(tags = t :: tags)
  def put(k: String, v: String): Data410 = copy(meta = meta.updated(k, v))
  def merge(other: Data410): Data410 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data410 {
  given Ordering[Data410] = Ordering.by(_.id)
  def empty: Data410 = Data410(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data410 =
    Data410(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data410] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
