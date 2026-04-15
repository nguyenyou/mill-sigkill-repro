package generated

final case class Data419(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data419 = copy(name = name.toUpperCase)
  def scale(k: Double): Data419 = copy(value = value * k)
  def addTag(t: String): Data419 = copy(tags = t :: tags)
  def put(k: String, v: String): Data419 = copy(meta = meta.updated(k, v))
  def merge(other: Data419): Data419 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data419 {
  given Ordering[Data419] = Ordering.by(_.id)
  def empty: Data419 = Data419(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data419 =
    Data419(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data419] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
