package generated

final case class Data146(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data146 = copy(name = name.toUpperCase)
  def scale(k: Double): Data146 = copy(value = value * k)
  def addTag(t: String): Data146 = copy(tags = t :: tags)
  def put(k: String, v: String): Data146 = copy(meta = meta.updated(k, v))
  def merge(other: Data146): Data146 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data146 {
  given Ordering[Data146] = Ordering.by(_.id)
  def empty: Data146 = Data146(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data146 =
    Data146(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data146] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
