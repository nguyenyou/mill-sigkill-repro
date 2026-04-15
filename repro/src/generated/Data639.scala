package generated

final case class Data639(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data639 = copy(name = name.toUpperCase)
  def scale(k: Double): Data639 = copy(value = value * k)
  def addTag(t: String): Data639 = copy(tags = t :: tags)
  def put(k: String, v: String): Data639 = copy(meta = meta.updated(k, v))
  def merge(other: Data639): Data639 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data639 {
  given Ordering[Data639] = Ordering.by(_.id)
  def empty: Data639 = Data639(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data639 =
    Data639(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data639] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
