package generated

final case class Data497(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data497 = copy(name = name.toUpperCase)
  def scale(k: Double): Data497 = copy(value = value * k)
  def addTag(t: String): Data497 = copy(tags = t :: tags)
  def put(k: String, v: String): Data497 = copy(meta = meta.updated(k, v))
  def merge(other: Data497): Data497 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data497 {
  given Ordering[Data497] = Ordering.by(_.id)
  def empty: Data497 = Data497(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data497 =
    Data497(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data497] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
