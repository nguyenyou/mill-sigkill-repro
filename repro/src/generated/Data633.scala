package generated

final case class Data633(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data633 = copy(name = name.toUpperCase)
  def scale(k: Double): Data633 = copy(value = value * k)
  def addTag(t: String): Data633 = copy(tags = t :: tags)
  def put(k: String, v: String): Data633 = copy(meta = meta.updated(k, v))
  def merge(other: Data633): Data633 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data633 {
  given Ordering[Data633] = Ordering.by(_.id)
  def empty: Data633 = Data633(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data633 =
    Data633(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data633] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
