package generated

final case class Data751(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data751 = copy(name = name.toUpperCase)
  def scale(k: Double): Data751 = copy(value = value * k)
  def addTag(t: String): Data751 = copy(tags = t :: tags)
  def put(k: String, v: String): Data751 = copy(meta = meta.updated(k, v))
  def merge(other: Data751): Data751 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data751 {
  given Ordering[Data751] = Ordering.by(_.id)
  def empty: Data751 = Data751(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data751 =
    Data751(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data751] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
