package generated

final case class Data140(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data140 = copy(name = name.toUpperCase)
  def scale(k: Double): Data140 = copy(value = value * k)
  def addTag(t: String): Data140 = copy(tags = t :: tags)
  def put(k: String, v: String): Data140 = copy(meta = meta.updated(k, v))
  def merge(other: Data140): Data140 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data140 {
  given Ordering[Data140] = Ordering.by(_.id)
  def empty: Data140 = Data140(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data140 =
    Data140(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data140] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
