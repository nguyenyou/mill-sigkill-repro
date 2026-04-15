package generated

final case class Data359(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data359 = copy(name = name.toUpperCase)
  def scale(k: Double): Data359 = copy(value = value * k)
  def addTag(t: String): Data359 = copy(tags = t :: tags)
  def put(k: String, v: String): Data359 = copy(meta = meta.updated(k, v))
  def merge(other: Data359): Data359 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data359 {
  given Ordering[Data359] = Ordering.by(_.id)
  def empty: Data359 = Data359(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data359 =
    Data359(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data359] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
