package generated

final case class Data612(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data612 = copy(name = name.toUpperCase)
  def scale(k: Double): Data612 = copy(value = value * k)
  def addTag(t: String): Data612 = copy(tags = t :: tags)
  def put(k: String, v: String): Data612 = copy(meta = meta.updated(k, v))
  def merge(other: Data612): Data612 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data612 {
  given Ordering[Data612] = Ordering.by(_.id)
  def empty: Data612 = Data612(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data612 =
    Data612(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data612] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
