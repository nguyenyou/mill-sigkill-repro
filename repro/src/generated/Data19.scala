package generated

final case class Data19(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data19 = copy(name = name.toUpperCase)
  def scale(k: Double): Data19 = copy(value = value * k)
  def addTag(t: String): Data19 = copy(tags = t :: tags)
  def put(k: String, v: String): Data19 = copy(meta = meta.updated(k, v))
  def merge(other: Data19): Data19 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data19 {
  given Ordering[Data19] = Ordering.by(_.id)
  def empty: Data19 = Data19(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data19 =
    Data19(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data19] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
