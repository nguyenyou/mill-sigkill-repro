package generated

final case class Data599(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data599 = copy(name = name.toUpperCase)
  def scale(k: Double): Data599 = copy(value = value * k)
  def addTag(t: String): Data599 = copy(tags = t :: tags)
  def put(k: String, v: String): Data599 = copy(meta = meta.updated(k, v))
  def merge(other: Data599): Data599 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data599 {
  given Ordering[Data599] = Ordering.by(_.id)
  def empty: Data599 = Data599(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data599 =
    Data599(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data599] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
