package generated

final case class Data323(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data323 = copy(name = name.toUpperCase)
  def scale(k: Double): Data323 = copy(value = value * k)
  def addTag(t: String): Data323 = copy(tags = t :: tags)
  def put(k: String, v: String): Data323 = copy(meta = meta.updated(k, v))
  def merge(other: Data323): Data323 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data323 {
  given Ordering[Data323] = Ordering.by(_.id)
  def empty: Data323 = Data323(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data323 =
    Data323(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data323] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
