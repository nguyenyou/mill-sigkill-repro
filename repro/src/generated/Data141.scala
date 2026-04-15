package generated

final case class Data141(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data141 = copy(name = name.toUpperCase)
  def scale(k: Double): Data141 = copy(value = value * k)
  def addTag(t: String): Data141 = copy(tags = t :: tags)
  def put(k: String, v: String): Data141 = copy(meta = meta.updated(k, v))
  def merge(other: Data141): Data141 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data141 {
  given Ordering[Data141] = Ordering.by(_.id)
  def empty: Data141 = Data141(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data141 =
    Data141(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data141] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
