package generated

final case class Data591(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data591 = copy(name = name.toUpperCase)
  def scale(k: Double): Data591 = copy(value = value * k)
  def addTag(t: String): Data591 = copy(tags = t :: tags)
  def put(k: String, v: String): Data591 = copy(meta = meta.updated(k, v))
  def merge(other: Data591): Data591 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data591 {
  given Ordering[Data591] = Ordering.by(_.id)
  def empty: Data591 = Data591(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data591 =
    Data591(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data591] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
