package generated

final case class Data42(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data42 = copy(name = name.toUpperCase)
  def scale(k: Double): Data42 = copy(value = value * k)
  def addTag(t: String): Data42 = copy(tags = t :: tags)
  def put(k: String, v: String): Data42 = copy(meta = meta.updated(k, v))
  def merge(other: Data42): Data42 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data42 {
  given Ordering[Data42] = Ordering.by(_.id)
  def empty: Data42 = Data42(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data42 =
    Data42(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data42] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
