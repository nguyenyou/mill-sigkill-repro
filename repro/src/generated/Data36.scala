package generated

final case class Data36(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data36 = copy(name = name.toUpperCase)
  def scale(k: Double): Data36 = copy(value = value * k)
  def addTag(t: String): Data36 = copy(tags = t :: tags)
  def put(k: String, v: String): Data36 = copy(meta = meta.updated(k, v))
  def merge(other: Data36): Data36 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data36 {
  given Ordering[Data36] = Ordering.by(_.id)
  def empty: Data36 = Data36(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data36 =
    Data36(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data36] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
