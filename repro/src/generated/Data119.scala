package generated

final case class Data119(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data119 = copy(name = name.toUpperCase)
  def scale(k: Double): Data119 = copy(value = value * k)
  def addTag(t: String): Data119 = copy(tags = t :: tags)
  def put(k: String, v: String): Data119 = copy(meta = meta.updated(k, v))
  def merge(other: Data119): Data119 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data119 {
  given Ordering[Data119] = Ordering.by(_.id)
  def empty: Data119 = Data119(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data119 =
    Data119(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data119] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
