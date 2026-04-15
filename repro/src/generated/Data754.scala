package generated

final case class Data754(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data754 = copy(name = name.toUpperCase)
  def scale(k: Double): Data754 = copy(value = value * k)
  def addTag(t: String): Data754 = copy(tags = t :: tags)
  def put(k: String, v: String): Data754 = copy(meta = meta.updated(k, v))
  def merge(other: Data754): Data754 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data754 {
  given Ordering[Data754] = Ordering.by(_.id)
  def empty: Data754 = Data754(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data754 =
    Data754(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data754] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
