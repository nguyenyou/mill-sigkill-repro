package generated

final case class Data554(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data554 = copy(name = name.toUpperCase)
  def scale(k: Double): Data554 = copy(value = value * k)
  def addTag(t: String): Data554 = copy(tags = t :: tags)
  def put(k: String, v: String): Data554 = copy(meta = meta.updated(k, v))
  def merge(other: Data554): Data554 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data554 {
  given Ordering[Data554] = Ordering.by(_.id)
  def empty: Data554 = Data554(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data554 =
    Data554(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data554] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
