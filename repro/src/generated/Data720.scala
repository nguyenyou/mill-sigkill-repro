package generated

final case class Data720(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data720 = copy(name = name.toUpperCase)
  def scale(k: Double): Data720 = copy(value = value * k)
  def addTag(t: String): Data720 = copy(tags = t :: tags)
  def put(k: String, v: String): Data720 = copy(meta = meta.updated(k, v))
  def merge(other: Data720): Data720 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data720 {
  given Ordering[Data720] = Ordering.by(_.id)
  def empty: Data720 = Data720(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data720 =
    Data720(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data720] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
