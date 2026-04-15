package generated

final case class Data800(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data800 = copy(name = name.toUpperCase)
  def scale(k: Double): Data800 = copy(value = value * k)
  def addTag(t: String): Data800 = copy(tags = t :: tags)
  def put(k: String, v: String): Data800 = copy(meta = meta.updated(k, v))
  def merge(other: Data800): Data800 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data800 {
  given Ordering[Data800] = Ordering.by(_.id)
  def empty: Data800 = Data800(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data800 =
    Data800(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data800] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
