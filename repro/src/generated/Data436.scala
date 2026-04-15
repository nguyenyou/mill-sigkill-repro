package generated

final case class Data436(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data436 = copy(name = name.toUpperCase)
  def scale(k: Double): Data436 = copy(value = value * k)
  def addTag(t: String): Data436 = copy(tags = t :: tags)
  def put(k: String, v: String): Data436 = copy(meta = meta.updated(k, v))
  def merge(other: Data436): Data436 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data436 {
  given Ordering[Data436] = Ordering.by(_.id)
  def empty: Data436 = Data436(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data436 =
    Data436(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data436] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
