package generated

final case class Data169(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data169 = copy(name = name.toUpperCase)
  def scale(k: Double): Data169 = copy(value = value * k)
  def addTag(t: String): Data169 = copy(tags = t :: tags)
  def put(k: String, v: String): Data169 = copy(meta = meta.updated(k, v))
  def merge(other: Data169): Data169 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data169 {
  given Ordering[Data169] = Ordering.by(_.id)
  def empty: Data169 = Data169(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data169 =
    Data169(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data169] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
