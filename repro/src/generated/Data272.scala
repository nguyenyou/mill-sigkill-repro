package generated

final case class Data272(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data272 = copy(name = name.toUpperCase)
  def scale(k: Double): Data272 = copy(value = value * k)
  def addTag(t: String): Data272 = copy(tags = t :: tags)
  def put(k: String, v: String): Data272 = copy(meta = meta.updated(k, v))
  def merge(other: Data272): Data272 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data272 {
  given Ordering[Data272] = Ordering.by(_.id)
  def empty: Data272 = Data272(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data272 =
    Data272(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data272] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
