package generated

final case class Data154(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data154 = copy(name = name.toUpperCase)
  def scale(k: Double): Data154 = copy(value = value * k)
  def addTag(t: String): Data154 = copy(tags = t :: tags)
  def put(k: String, v: String): Data154 = copy(meta = meta.updated(k, v))
  def merge(other: Data154): Data154 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data154 {
  given Ordering[Data154] = Ordering.by(_.id)
  def empty: Data154 = Data154(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data154 =
    Data154(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data154] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
