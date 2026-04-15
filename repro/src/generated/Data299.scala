package generated

final case class Data299(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data299 = copy(name = name.toUpperCase)
  def scale(k: Double): Data299 = copy(value = value * k)
  def addTag(t: String): Data299 = copy(tags = t :: tags)
  def put(k: String, v: String): Data299 = copy(meta = meta.updated(k, v))
  def merge(other: Data299): Data299 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data299 {
  given Ordering[Data299] = Ordering.by(_.id)
  def empty: Data299 = Data299(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data299 =
    Data299(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data299] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
