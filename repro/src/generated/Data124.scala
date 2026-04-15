package generated

final case class Data124(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data124 = copy(name = name.toUpperCase)
  def scale(k: Double): Data124 = copy(value = value * k)
  def addTag(t: String): Data124 = copy(tags = t :: tags)
  def put(k: String, v: String): Data124 = copy(meta = meta.updated(k, v))
  def merge(other: Data124): Data124 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data124 {
  given Ordering[Data124] = Ordering.by(_.id)
  def empty: Data124 = Data124(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data124 =
    Data124(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data124] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
