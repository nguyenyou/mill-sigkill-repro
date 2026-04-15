package generated

final case class Data39(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data39 = copy(name = name.toUpperCase)
  def scale(k: Double): Data39 = copy(value = value * k)
  def addTag(t: String): Data39 = copy(tags = t :: tags)
  def put(k: String, v: String): Data39 = copy(meta = meta.updated(k, v))
  def merge(other: Data39): Data39 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data39 {
  given Ordering[Data39] = Ordering.by(_.id)
  def empty: Data39 = Data39(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data39 =
    Data39(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data39] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
