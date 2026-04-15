package generated

final case class Data768(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data768 = copy(name = name.toUpperCase)
  def scale(k: Double): Data768 = copy(value = value * k)
  def addTag(t: String): Data768 = copy(tags = t :: tags)
  def put(k: String, v: String): Data768 = copy(meta = meta.updated(k, v))
  def merge(other: Data768): Data768 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data768 {
  given Ordering[Data768] = Ordering.by(_.id)
  def empty: Data768 = Data768(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data768 =
    Data768(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data768] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
