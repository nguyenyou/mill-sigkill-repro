package generated

final case class Data243(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data243 = copy(name = name.toUpperCase)
  def scale(k: Double): Data243 = copy(value = value * k)
  def addTag(t: String): Data243 = copy(tags = t :: tags)
  def put(k: String, v: String): Data243 = copy(meta = meta.updated(k, v))
  def merge(other: Data243): Data243 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data243 {
  given Ordering[Data243] = Ordering.by(_.id)
  def empty: Data243 = Data243(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data243 =
    Data243(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data243] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
