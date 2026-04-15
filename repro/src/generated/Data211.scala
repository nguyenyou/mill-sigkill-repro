package generated

final case class Data211(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data211 = copy(name = name.toUpperCase)
  def scale(k: Double): Data211 = copy(value = value * k)
  def addTag(t: String): Data211 = copy(tags = t :: tags)
  def put(k: String, v: String): Data211 = copy(meta = meta.updated(k, v))
  def merge(other: Data211): Data211 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data211 {
  given Ordering[Data211] = Ordering.by(_.id)
  def empty: Data211 = Data211(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data211 =
    Data211(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data211] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
