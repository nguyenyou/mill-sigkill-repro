package generated

final case class Data610(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data610 = copy(name = name.toUpperCase)
  def scale(k: Double): Data610 = copy(value = value * k)
  def addTag(t: String): Data610 = copy(tags = t :: tags)
  def put(k: String, v: String): Data610 = copy(meta = meta.updated(k, v))
  def merge(other: Data610): Data610 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data610 {
  given Ordering[Data610] = Ordering.by(_.id)
  def empty: Data610 = Data610(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data610 =
    Data610(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data610] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
