package generated

final case class Data388(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data388 = copy(name = name.toUpperCase)
  def scale(k: Double): Data388 = copy(value = value * k)
  def addTag(t: String): Data388 = copy(tags = t :: tags)
  def put(k: String, v: String): Data388 = copy(meta = meta.updated(k, v))
  def merge(other: Data388): Data388 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data388 {
  given Ordering[Data388] = Ordering.by(_.id)
  def empty: Data388 = Data388(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data388 =
    Data388(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data388] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
