package generated

final case class Data80(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data80 = copy(name = name.toUpperCase)
  def scale(k: Double): Data80 = copy(value = value * k)
  def addTag(t: String): Data80 = copy(tags = t :: tags)
  def put(k: String, v: String): Data80 = copy(meta = meta.updated(k, v))
  def merge(other: Data80): Data80 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data80 {
  given Ordering[Data80] = Ordering.by(_.id)
  def empty: Data80 = Data80(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data80 =
    Data80(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data80] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
