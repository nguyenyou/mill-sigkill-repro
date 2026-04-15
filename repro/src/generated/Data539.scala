package generated

final case class Data539(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data539 = copy(name = name.toUpperCase)
  def scale(k: Double): Data539 = copy(value = value * k)
  def addTag(t: String): Data539 = copy(tags = t :: tags)
  def put(k: String, v: String): Data539 = copy(meta = meta.updated(k, v))
  def merge(other: Data539): Data539 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data539 {
  given Ordering[Data539] = Ordering.by(_.id)
  def empty: Data539 = Data539(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data539 =
    Data539(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data539] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
