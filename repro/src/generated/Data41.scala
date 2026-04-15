package generated

final case class Data41(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data41 = copy(name = name.toUpperCase)
  def scale(k: Double): Data41 = copy(value = value * k)
  def addTag(t: String): Data41 = copy(tags = t :: tags)
  def put(k: String, v: String): Data41 = copy(meta = meta.updated(k, v))
  def merge(other: Data41): Data41 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data41 {
  given Ordering[Data41] = Ordering.by(_.id)
  def empty: Data41 = Data41(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data41 =
    Data41(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data41] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
