package generated

final case class Data240(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data240 = copy(name = name.toUpperCase)
  def scale(k: Double): Data240 = copy(value = value * k)
  def addTag(t: String): Data240 = copy(tags = t :: tags)
  def put(k: String, v: String): Data240 = copy(meta = meta.updated(k, v))
  def merge(other: Data240): Data240 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data240 {
  given Ordering[Data240] = Ordering.by(_.id)
  def empty: Data240 = Data240(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data240 =
    Data240(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data240] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
