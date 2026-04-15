package generated

final case class Data457(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data457 = copy(name = name.toUpperCase)
  def scale(k: Double): Data457 = copy(value = value * k)
  def addTag(t: String): Data457 = copy(tags = t :: tags)
  def put(k: String, v: String): Data457 = copy(meta = meta.updated(k, v))
  def merge(other: Data457): Data457 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data457 {
  given Ordering[Data457] = Ordering.by(_.id)
  def empty: Data457 = Data457(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data457 =
    Data457(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data457] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
