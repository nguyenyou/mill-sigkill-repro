package generated

final case class Data713(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data713 = copy(name = name.toUpperCase)
  def scale(k: Double): Data713 = copy(value = value * k)
  def addTag(t: String): Data713 = copy(tags = t :: tags)
  def put(k: String, v: String): Data713 = copy(meta = meta.updated(k, v))
  def merge(other: Data713): Data713 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data713 {
  given Ordering[Data713] = Ordering.by(_.id)
  def empty: Data713 = Data713(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data713 =
    Data713(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data713] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
