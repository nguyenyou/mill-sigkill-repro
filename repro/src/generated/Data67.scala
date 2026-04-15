package generated

final case class Data67(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data67 = copy(name = name.toUpperCase)
  def scale(k: Double): Data67 = copy(value = value * k)
  def addTag(t: String): Data67 = copy(tags = t :: tags)
  def put(k: String, v: String): Data67 = copy(meta = meta.updated(k, v))
  def merge(other: Data67): Data67 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data67 {
  given Ordering[Data67] = Ordering.by(_.id)
  def empty: Data67 = Data67(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data67 =
    Data67(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data67] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
