package generated

final case class Data963(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data963 = copy(name = name.toUpperCase)
  def scale(k: Double): Data963 = copy(value = value * k)
  def addTag(t: String): Data963 = copy(tags = t :: tags)
  def put(k: String, v: String): Data963 = copy(meta = meta.updated(k, v))
  def merge(other: Data963): Data963 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data963 {
  given Ordering[Data963] = Ordering.by(_.id)
  def empty: Data963 = Data963(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data963 =
    Data963(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data963] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
