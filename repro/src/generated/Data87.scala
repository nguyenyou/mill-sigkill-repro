package generated

final case class Data87(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data87 = copy(name = name.toUpperCase)
  def scale(k: Double): Data87 = copy(value = value * k)
  def addTag(t: String): Data87 = copy(tags = t :: tags)
  def put(k: String, v: String): Data87 = copy(meta = meta.updated(k, v))
  def merge(other: Data87): Data87 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data87 {
  given Ordering[Data87] = Ordering.by(_.id)
  def empty: Data87 = Data87(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data87 =
    Data87(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data87] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
