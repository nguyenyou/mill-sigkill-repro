package generated

final case class Data21(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data21 = copy(name = name.toUpperCase)
  def scale(k: Double): Data21 = copy(value = value * k)
  def addTag(t: String): Data21 = copy(tags = t :: tags)
  def put(k: String, v: String): Data21 = copy(meta = meta.updated(k, v))
  def merge(other: Data21): Data21 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data21 {
  given Ordering[Data21] = Ordering.by(_.id)
  def empty: Data21 = Data21(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data21 =
    Data21(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data21] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
