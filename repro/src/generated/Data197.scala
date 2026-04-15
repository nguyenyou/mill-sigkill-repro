package generated

final case class Data197(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data197 = copy(name = name.toUpperCase)
  def scale(k: Double): Data197 = copy(value = value * k)
  def addTag(t: String): Data197 = copy(tags = t :: tags)
  def put(k: String, v: String): Data197 = copy(meta = meta.updated(k, v))
  def merge(other: Data197): Data197 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data197 {
  given Ordering[Data197] = Ordering.by(_.id)
  def empty: Data197 = Data197(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data197 =
    Data197(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data197] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
