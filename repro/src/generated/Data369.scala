package generated

final case class Data369(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data369 = copy(name = name.toUpperCase)
  def scale(k: Double): Data369 = copy(value = value * k)
  def addTag(t: String): Data369 = copy(tags = t :: tags)
  def put(k: String, v: String): Data369 = copy(meta = meta.updated(k, v))
  def merge(other: Data369): Data369 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data369 {
  given Ordering[Data369] = Ordering.by(_.id)
  def empty: Data369 = Data369(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data369 =
    Data369(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data369] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
