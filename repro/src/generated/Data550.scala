package generated

final case class Data550(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data550 = copy(name = name.toUpperCase)
  def scale(k: Double): Data550 = copy(value = value * k)
  def addTag(t: String): Data550 = copy(tags = t :: tags)
  def put(k: String, v: String): Data550 = copy(meta = meta.updated(k, v))
  def merge(other: Data550): Data550 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data550 {
  given Ordering[Data550] = Ordering.by(_.id)
  def empty: Data550 = Data550(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data550 =
    Data550(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data550] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
