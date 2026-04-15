package generated

final case class Data387(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data387 = copy(name = name.toUpperCase)
  def scale(k: Double): Data387 = copy(value = value * k)
  def addTag(t: String): Data387 = copy(tags = t :: tags)
  def put(k: String, v: String): Data387 = copy(meta = meta.updated(k, v))
  def merge(other: Data387): Data387 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data387 {
  given Ordering[Data387] = Ordering.by(_.id)
  def empty: Data387 = Data387(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data387 =
    Data387(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data387] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
