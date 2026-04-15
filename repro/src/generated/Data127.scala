package generated

final case class Data127(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data127 = copy(name = name.toUpperCase)
  def scale(k: Double): Data127 = copy(value = value * k)
  def addTag(t: String): Data127 = copy(tags = t :: tags)
  def put(k: String, v: String): Data127 = copy(meta = meta.updated(k, v))
  def merge(other: Data127): Data127 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data127 {
  given Ordering[Data127] = Ordering.by(_.id)
  def empty: Data127 = Data127(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data127 =
    Data127(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data127] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
