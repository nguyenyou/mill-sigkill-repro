package generated

final case class Data767(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data767 = copy(name = name.toUpperCase)
  def scale(k: Double): Data767 = copy(value = value * k)
  def addTag(t: String): Data767 = copy(tags = t :: tags)
  def put(k: String, v: String): Data767 = copy(meta = meta.updated(k, v))
  def merge(other: Data767): Data767 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data767 {
  given Ordering[Data767] = Ordering.by(_.id)
  def empty: Data767 = Data767(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data767 =
    Data767(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data767] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
