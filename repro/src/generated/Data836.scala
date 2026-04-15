package generated

final case class Data836(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data836 = copy(name = name.toUpperCase)
  def scale(k: Double): Data836 = copy(value = value * k)
  def addTag(t: String): Data836 = copy(tags = t :: tags)
  def put(k: String, v: String): Data836 = copy(meta = meta.updated(k, v))
  def merge(other: Data836): Data836 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data836 {
  given Ordering[Data836] = Ordering.by(_.id)
  def empty: Data836 = Data836(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data836 =
    Data836(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data836] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
