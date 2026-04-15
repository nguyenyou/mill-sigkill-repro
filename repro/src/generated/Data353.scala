package generated

final case class Data353(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data353 = copy(name = name.toUpperCase)
  def scale(k: Double): Data353 = copy(value = value * k)
  def addTag(t: String): Data353 = copy(tags = t :: tags)
  def put(k: String, v: String): Data353 = copy(meta = meta.updated(k, v))
  def merge(other: Data353): Data353 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data353 {
  given Ordering[Data353] = Ordering.by(_.id)
  def empty: Data353 = Data353(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data353 =
    Data353(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data353] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
