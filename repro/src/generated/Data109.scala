package generated

final case class Data109(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data109 = copy(name = name.toUpperCase)
  def scale(k: Double): Data109 = copy(value = value * k)
  def addTag(t: String): Data109 = copy(tags = t :: tags)
  def put(k: String, v: String): Data109 = copy(meta = meta.updated(k, v))
  def merge(other: Data109): Data109 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data109 {
  given Ordering[Data109] = Ordering.by(_.id)
  def empty: Data109 = Data109(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data109 =
    Data109(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data109] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
