package generated

final case class Data15(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data15 = copy(name = name.toUpperCase)
  def scale(k: Double): Data15 = copy(value = value * k)
  def addTag(t: String): Data15 = copy(tags = t :: tags)
  def put(k: String, v: String): Data15 = copy(meta = meta.updated(k, v))
  def merge(other: Data15): Data15 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data15 {
  given Ordering[Data15] = Ordering.by(_.id)
  def empty: Data15 = Data15(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data15 =
    Data15(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data15] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
