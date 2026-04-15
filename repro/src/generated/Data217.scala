package generated

final case class Data217(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data217 = copy(name = name.toUpperCase)
  def scale(k: Double): Data217 = copy(value = value * k)
  def addTag(t: String): Data217 = copy(tags = t :: tags)
  def put(k: String, v: String): Data217 = copy(meta = meta.updated(k, v))
  def merge(other: Data217): Data217 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data217 {
  given Ordering[Data217] = Ordering.by(_.id)
  def empty: Data217 = Data217(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data217 =
    Data217(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data217] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
