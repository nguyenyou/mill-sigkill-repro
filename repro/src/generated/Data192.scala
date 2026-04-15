package generated

final case class Data192(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data192 = copy(name = name.toUpperCase)
  def scale(k: Double): Data192 = copy(value = value * k)
  def addTag(t: String): Data192 = copy(tags = t :: tags)
  def put(k: String, v: String): Data192 = copy(meta = meta.updated(k, v))
  def merge(other: Data192): Data192 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data192 {
  given Ordering[Data192] = Ordering.by(_.id)
  def empty: Data192 = Data192(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data192 =
    Data192(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data192] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
