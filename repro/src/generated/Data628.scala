package generated

final case class Data628(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data628 = copy(name = name.toUpperCase)
  def scale(k: Double): Data628 = copy(value = value * k)
  def addTag(t: String): Data628 = copy(tags = t :: tags)
  def put(k: String, v: String): Data628 = copy(meta = meta.updated(k, v))
  def merge(other: Data628): Data628 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data628 {
  given Ordering[Data628] = Ordering.by(_.id)
  def empty: Data628 = Data628(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data628 =
    Data628(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data628] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
