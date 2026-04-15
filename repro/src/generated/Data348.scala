package generated

final case class Data348(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data348 = copy(name = name.toUpperCase)
  def scale(k: Double): Data348 = copy(value = value * k)
  def addTag(t: String): Data348 = copy(tags = t :: tags)
  def put(k: String, v: String): Data348 = copy(meta = meta.updated(k, v))
  def merge(other: Data348): Data348 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data348 {
  given Ordering[Data348] = Ordering.by(_.id)
  def empty: Data348 = Data348(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data348 =
    Data348(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data348] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
