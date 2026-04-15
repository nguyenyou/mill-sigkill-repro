package generated

final case class Data702(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data702 = copy(name = name.toUpperCase)
  def scale(k: Double): Data702 = copy(value = value * k)
  def addTag(t: String): Data702 = copy(tags = t :: tags)
  def put(k: String, v: String): Data702 = copy(meta = meta.updated(k, v))
  def merge(other: Data702): Data702 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data702 {
  given Ordering[Data702] = Ordering.by(_.id)
  def empty: Data702 = Data702(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data702 =
    Data702(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data702] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
