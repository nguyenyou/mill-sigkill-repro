package generated

final case class Data660(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data660 = copy(name = name.toUpperCase)
  def scale(k: Double): Data660 = copy(value = value * k)
  def addTag(t: String): Data660 = copy(tags = t :: tags)
  def put(k: String, v: String): Data660 = copy(meta = meta.updated(k, v))
  def merge(other: Data660): Data660 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data660 {
  given Ordering[Data660] = Ordering.by(_.id)
  def empty: Data660 = Data660(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data660 =
    Data660(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data660] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
