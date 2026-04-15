package generated

final case class Data617(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data617 = copy(name = name.toUpperCase)
  def scale(k: Double): Data617 = copy(value = value * k)
  def addTag(t: String): Data617 = copy(tags = t :: tags)
  def put(k: String, v: String): Data617 = copy(meta = meta.updated(k, v))
  def merge(other: Data617): Data617 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data617 {
  given Ordering[Data617] = Ordering.by(_.id)
  def empty: Data617 = Data617(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data617 =
    Data617(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data617] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
