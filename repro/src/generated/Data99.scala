package generated

final case class Data99(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data99 = copy(name = name.toUpperCase)
  def scale(k: Double): Data99 = copy(value = value * k)
  def addTag(t: String): Data99 = copy(tags = t :: tags)
  def put(k: String, v: String): Data99 = copy(meta = meta.updated(k, v))
  def merge(other: Data99): Data99 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data99 {
  given Ordering[Data99] = Ordering.by(_.id)
  def empty: Data99 = Data99(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data99 =
    Data99(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data99] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
