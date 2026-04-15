package generated

final case class Data688(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data688 = copy(name = name.toUpperCase)
  def scale(k: Double): Data688 = copy(value = value * k)
  def addTag(t: String): Data688 = copy(tags = t :: tags)
  def put(k: String, v: String): Data688 = copy(meta = meta.updated(k, v))
  def merge(other: Data688): Data688 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data688 {
  given Ordering[Data688] = Ordering.by(_.id)
  def empty: Data688 = Data688(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data688 =
    Data688(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data688] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
