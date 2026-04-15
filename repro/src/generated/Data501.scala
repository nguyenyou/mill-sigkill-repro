package generated

final case class Data501(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data501 = copy(name = name.toUpperCase)
  def scale(k: Double): Data501 = copy(value = value * k)
  def addTag(t: String): Data501 = copy(tags = t :: tags)
  def put(k: String, v: String): Data501 = copy(meta = meta.updated(k, v))
  def merge(other: Data501): Data501 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data501 {
  given Ordering[Data501] = Ordering.by(_.id)
  def empty: Data501 = Data501(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data501 =
    Data501(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data501] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
