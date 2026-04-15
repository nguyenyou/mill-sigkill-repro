package generated

final case class Data24(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data24 = copy(name = name.toUpperCase)
  def scale(k: Double): Data24 = copy(value = value * k)
  def addTag(t: String): Data24 = copy(tags = t :: tags)
  def put(k: String, v: String): Data24 = copy(meta = meta.updated(k, v))
  def merge(other: Data24): Data24 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data24 {
  given Ordering[Data24] = Ordering.by(_.id)
  def empty: Data24 = Data24(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data24 =
    Data24(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data24] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
