package generated

final case class Data92(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data92 = copy(name = name.toUpperCase)
  def scale(k: Double): Data92 = copy(value = value * k)
  def addTag(t: String): Data92 = copy(tags = t :: tags)
  def put(k: String, v: String): Data92 = copy(meta = meta.updated(k, v))
  def merge(other: Data92): Data92 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data92 {
  given Ordering[Data92] = Ordering.by(_.id)
  def empty: Data92 = Data92(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data92 =
    Data92(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data92] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
