package generated

final case class Data2(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data2 = copy(name = name.toUpperCase)
  def scale(k: Double): Data2 = copy(value = value * k)
  def addTag(t: String): Data2 = copy(tags = t :: tags)
  def put(k: String, v: String): Data2 = copy(meta = meta.updated(k, v))
  def merge(other: Data2): Data2 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data2 {
  given Ordering[Data2] = Ordering.by(_.id)
  def empty: Data2 = Data2(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data2 =
    Data2(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data2] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
