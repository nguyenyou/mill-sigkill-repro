package generated

final case class Data769(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data769 = copy(name = name.toUpperCase)
  def scale(k: Double): Data769 = copy(value = value * k)
  def addTag(t: String): Data769 = copy(tags = t :: tags)
  def put(k: String, v: String): Data769 = copy(meta = meta.updated(k, v))
  def merge(other: Data769): Data769 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data769 {
  given Ordering[Data769] = Ordering.by(_.id)
  def empty: Data769 = Data769(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data769 =
    Data769(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data769] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
