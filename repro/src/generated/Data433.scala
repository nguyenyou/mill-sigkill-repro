package generated

final case class Data433(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data433 = copy(name = name.toUpperCase)
  def scale(k: Double): Data433 = copy(value = value * k)
  def addTag(t: String): Data433 = copy(tags = t :: tags)
  def put(k: String, v: String): Data433 = copy(meta = meta.updated(k, v))
  def merge(other: Data433): Data433 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data433 {
  given Ordering[Data433] = Ordering.by(_.id)
  def empty: Data433 = Data433(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data433 =
    Data433(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data433] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
