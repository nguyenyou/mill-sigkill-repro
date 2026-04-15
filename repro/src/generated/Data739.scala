package generated

final case class Data739(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data739 = copy(name = name.toUpperCase)
  def scale(k: Double): Data739 = copy(value = value * k)
  def addTag(t: String): Data739 = copy(tags = t :: tags)
  def put(k: String, v: String): Data739 = copy(meta = meta.updated(k, v))
  def merge(other: Data739): Data739 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data739 {
  given Ordering[Data739] = Ordering.by(_.id)
  def empty: Data739 = Data739(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data739 =
    Data739(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data739] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
