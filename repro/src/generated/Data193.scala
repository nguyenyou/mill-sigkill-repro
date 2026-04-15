package generated

final case class Data193(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data193 = copy(name = name.toUpperCase)
  def scale(k: Double): Data193 = copy(value = value * k)
  def addTag(t: String): Data193 = copy(tags = t :: tags)
  def put(k: String, v: String): Data193 = copy(meta = meta.updated(k, v))
  def merge(other: Data193): Data193 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data193 {
  given Ordering[Data193] = Ordering.by(_.id)
  def empty: Data193 = Data193(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data193 =
    Data193(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data193] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
