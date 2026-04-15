package generated

final case class Data623(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data623 = copy(name = name.toUpperCase)
  def scale(k: Double): Data623 = copy(value = value * k)
  def addTag(t: String): Data623 = copy(tags = t :: tags)
  def put(k: String, v: String): Data623 = copy(meta = meta.updated(k, v))
  def merge(other: Data623): Data623 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data623 {
  given Ordering[Data623] = Ordering.by(_.id)
  def empty: Data623 = Data623(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data623 =
    Data623(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data623] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
