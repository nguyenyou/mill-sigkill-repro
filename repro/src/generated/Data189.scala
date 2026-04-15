package generated

final case class Data189(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data189 = copy(name = name.toUpperCase)
  def scale(k: Double): Data189 = copy(value = value * k)
  def addTag(t: String): Data189 = copy(tags = t :: tags)
  def put(k: String, v: String): Data189 = copy(meta = meta.updated(k, v))
  def merge(other: Data189): Data189 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data189 {
  given Ordering[Data189] = Ordering.by(_.id)
  def empty: Data189 = Data189(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data189 =
    Data189(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data189] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
