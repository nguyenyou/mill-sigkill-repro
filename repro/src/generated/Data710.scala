package generated

final case class Data710(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data710 = copy(name = name.toUpperCase)
  def scale(k: Double): Data710 = copy(value = value * k)
  def addTag(t: String): Data710 = copy(tags = t :: tags)
  def put(k: String, v: String): Data710 = copy(meta = meta.updated(k, v))
  def merge(other: Data710): Data710 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data710 {
  given Ordering[Data710] = Ordering.by(_.id)
  def empty: Data710 = Data710(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data710 =
    Data710(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data710] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
