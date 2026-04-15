package generated

final case class Data51(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data51 = copy(name = name.toUpperCase)
  def scale(k: Double): Data51 = copy(value = value * k)
  def addTag(t: String): Data51 = copy(tags = t :: tags)
  def put(k: String, v: String): Data51 = copy(meta = meta.updated(k, v))
  def merge(other: Data51): Data51 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data51 {
  given Ordering[Data51] = Ordering.by(_.id)
  def empty: Data51 = Data51(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data51 =
    Data51(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data51] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
