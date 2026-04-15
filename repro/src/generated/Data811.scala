package generated

final case class Data811(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data811 = copy(name = name.toUpperCase)
  def scale(k: Double): Data811 = copy(value = value * k)
  def addTag(t: String): Data811 = copy(tags = t :: tags)
  def put(k: String, v: String): Data811 = copy(meta = meta.updated(k, v))
  def merge(other: Data811): Data811 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data811 {
  given Ordering[Data811] = Ordering.by(_.id)
  def empty: Data811 = Data811(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data811 =
    Data811(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data811] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
