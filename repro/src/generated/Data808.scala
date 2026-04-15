package generated

final case class Data808(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data808 = copy(name = name.toUpperCase)
  def scale(k: Double): Data808 = copy(value = value * k)
  def addTag(t: String): Data808 = copy(tags = t :: tags)
  def put(k: String, v: String): Data808 = copy(meta = meta.updated(k, v))
  def merge(other: Data808): Data808 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data808 {
  given Ordering[Data808] = Ordering.by(_.id)
  def empty: Data808 = Data808(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data808 =
    Data808(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data808] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
