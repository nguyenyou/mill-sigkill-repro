package generated

final case class Data961(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data961 = copy(name = name.toUpperCase)
  def scale(k: Double): Data961 = copy(value = value * k)
  def addTag(t: String): Data961 = copy(tags = t :: tags)
  def put(k: String, v: String): Data961 = copy(meta = meta.updated(k, v))
  def merge(other: Data961): Data961 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data961 {
  given Ordering[Data961] = Ordering.by(_.id)
  def empty: Data961 = Data961(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data961 =
    Data961(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data961] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
