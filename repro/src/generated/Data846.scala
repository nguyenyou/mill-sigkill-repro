package generated

final case class Data846(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data846 = copy(name = name.toUpperCase)
  def scale(k: Double): Data846 = copy(value = value * k)
  def addTag(t: String): Data846 = copy(tags = t :: tags)
  def put(k: String, v: String): Data846 = copy(meta = meta.updated(k, v))
  def merge(other: Data846): Data846 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data846 {
  given Ordering[Data846] = Ordering.by(_.id)
  def empty: Data846 = Data846(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data846 =
    Data846(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data846] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
