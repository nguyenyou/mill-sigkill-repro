package generated

final case class Data514(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data514 = copy(name = name.toUpperCase)
  def scale(k: Double): Data514 = copy(value = value * k)
  def addTag(t: String): Data514 = copy(tags = t :: tags)
  def put(k: String, v: String): Data514 = copy(meta = meta.updated(k, v))
  def merge(other: Data514): Data514 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data514 {
  given Ordering[Data514] = Ordering.by(_.id)
  def empty: Data514 = Data514(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data514 =
    Data514(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data514] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
