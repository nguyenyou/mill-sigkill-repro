package generated

final case class Data717(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data717 = copy(name = name.toUpperCase)
  def scale(k: Double): Data717 = copy(value = value * k)
  def addTag(t: String): Data717 = copy(tags = t :: tags)
  def put(k: String, v: String): Data717 = copy(meta = meta.updated(k, v))
  def merge(other: Data717): Data717 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data717 {
  given Ordering[Data717] = Ordering.by(_.id)
  def empty: Data717 = Data717(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data717 =
    Data717(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data717] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
