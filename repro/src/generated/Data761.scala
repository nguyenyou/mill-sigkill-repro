package generated

final case class Data761(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data761 = copy(name = name.toUpperCase)
  def scale(k: Double): Data761 = copy(value = value * k)
  def addTag(t: String): Data761 = copy(tags = t :: tags)
  def put(k: String, v: String): Data761 = copy(meta = meta.updated(k, v))
  def merge(other: Data761): Data761 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data761 {
  given Ordering[Data761] = Ordering.by(_.id)
  def empty: Data761 = Data761(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data761 =
    Data761(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data761] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
