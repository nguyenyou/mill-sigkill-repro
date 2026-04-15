package generated

final case class Data378(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data378 = copy(name = name.toUpperCase)
  def scale(k: Double): Data378 = copy(value = value * k)
  def addTag(t: String): Data378 = copy(tags = t :: tags)
  def put(k: String, v: String): Data378 = copy(meta = meta.updated(k, v))
  def merge(other: Data378): Data378 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data378 {
  given Ordering[Data378] = Ordering.by(_.id)
  def empty: Data378 = Data378(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data378 =
    Data378(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data378] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
