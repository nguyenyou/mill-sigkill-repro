package generated

final case class Data499(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data499 = copy(name = name.toUpperCase)
  def scale(k: Double): Data499 = copy(value = value * k)
  def addTag(t: String): Data499 = copy(tags = t :: tags)
  def put(k: String, v: String): Data499 = copy(meta = meta.updated(k, v))
  def merge(other: Data499): Data499 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data499 {
  given Ordering[Data499] = Ordering.by(_.id)
  def empty: Data499 = Data499(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data499 =
    Data499(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data499] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
