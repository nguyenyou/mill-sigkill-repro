package generated

final case class Data974(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data974 = copy(name = name.toUpperCase)
  def scale(k: Double): Data974 = copy(value = value * k)
  def addTag(t: String): Data974 = copy(tags = t :: tags)
  def put(k: String, v: String): Data974 = copy(meta = meta.updated(k, v))
  def merge(other: Data974): Data974 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data974 {
  given Ordering[Data974] = Ordering.by(_.id)
  def empty: Data974 = Data974(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data974 =
    Data974(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data974] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
