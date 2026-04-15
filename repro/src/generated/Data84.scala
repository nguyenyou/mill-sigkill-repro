package generated

final case class Data84(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data84 = copy(name = name.toUpperCase)
  def scale(k: Double): Data84 = copy(value = value * k)
  def addTag(t: String): Data84 = copy(tags = t :: tags)
  def put(k: String, v: String): Data84 = copy(meta = meta.updated(k, v))
  def merge(other: Data84): Data84 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data84 {
  given Ordering[Data84] = Ordering.by(_.id)
  def empty: Data84 = Data84(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data84 =
    Data84(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data84] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
