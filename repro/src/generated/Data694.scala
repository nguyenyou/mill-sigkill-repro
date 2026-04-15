package generated

final case class Data694(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data694 = copy(name = name.toUpperCase)
  def scale(k: Double): Data694 = copy(value = value * k)
  def addTag(t: String): Data694 = copy(tags = t :: tags)
  def put(k: String, v: String): Data694 = copy(meta = meta.updated(k, v))
  def merge(other: Data694): Data694 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data694 {
  given Ordering[Data694] = Ordering.by(_.id)
  def empty: Data694 = Data694(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data694 =
    Data694(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data694] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
