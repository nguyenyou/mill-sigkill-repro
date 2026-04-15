package generated

final case class Data721(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data721 = copy(name = name.toUpperCase)
  def scale(k: Double): Data721 = copy(value = value * k)
  def addTag(t: String): Data721 = copy(tags = t :: tags)
  def put(k: String, v: String): Data721 = copy(meta = meta.updated(k, v))
  def merge(other: Data721): Data721 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data721 {
  given Ordering[Data721] = Ordering.by(_.id)
  def empty: Data721 = Data721(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data721 =
    Data721(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data721] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
