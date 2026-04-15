package generated

final case class Data520(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data520 = copy(name = name.toUpperCase)
  def scale(k: Double): Data520 = copy(value = value * k)
  def addTag(t: String): Data520 = copy(tags = t :: tags)
  def put(k: String, v: String): Data520 = copy(meta = meta.updated(k, v))
  def merge(other: Data520): Data520 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data520 {
  given Ordering[Data520] = Ordering.by(_.id)
  def empty: Data520 = Data520(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data520 =
    Data520(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data520] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
