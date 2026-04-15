package generated

final case class Data68(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data68 = copy(name = name.toUpperCase)
  def scale(k: Double): Data68 = copy(value = value * k)
  def addTag(t: String): Data68 = copy(tags = t :: tags)
  def put(k: String, v: String): Data68 = copy(meta = meta.updated(k, v))
  def merge(other: Data68): Data68 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data68 {
  given Ordering[Data68] = Ordering.by(_.id)
  def empty: Data68 = Data68(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data68 =
    Data68(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data68] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
