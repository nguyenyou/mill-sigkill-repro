package generated

final case class Data1457(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1457 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1457 = copy(value = value * k)
  def addTag(t: String): Data1457 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1457 = copy(meta = meta.updated(k, v))
  def merge(other: Data1457): Data1457 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1457 {
  given Ordering[Data1457] = Ordering.by(_.id)
  def empty: Data1457 = Data1457(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1457 =
    Data1457(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1457] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
