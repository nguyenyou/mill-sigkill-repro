package generated

final case class Data443(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data443 = copy(name = name.toUpperCase)
  def scale(k: Double): Data443 = copy(value = value * k)
  def addTag(t: String): Data443 = copy(tags = t :: tags)
  def put(k: String, v: String): Data443 = copy(meta = meta.updated(k, v))
  def merge(other: Data443): Data443 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data443 {
  given Ordering[Data443] = Ordering.by(_.id)
  def empty: Data443 = Data443(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data443 =
    Data443(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data443] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
