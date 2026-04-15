package generated

final case class Data707(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data707 = copy(name = name.toUpperCase)
  def scale(k: Double): Data707 = copy(value = value * k)
  def addTag(t: String): Data707 = copy(tags = t :: tags)
  def put(k: String, v: String): Data707 = copy(meta = meta.updated(k, v))
  def merge(other: Data707): Data707 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data707 {
  given Ordering[Data707] = Ordering.by(_.id)
  def empty: Data707 = Data707(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data707 =
    Data707(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data707] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
