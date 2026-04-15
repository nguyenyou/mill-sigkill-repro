package generated

final case class Data400(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data400 = copy(name = name.toUpperCase)
  def scale(k: Double): Data400 = copy(value = value * k)
  def addTag(t: String): Data400 = copy(tags = t :: tags)
  def put(k: String, v: String): Data400 = copy(meta = meta.updated(k, v))
  def merge(other: Data400): Data400 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data400 {
  given Ordering[Data400] = Ordering.by(_.id)
  def empty: Data400 = Data400(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data400 =
    Data400(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data400] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
