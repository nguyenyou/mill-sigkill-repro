package generated

final case class Data131(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data131 = copy(name = name.toUpperCase)
  def scale(k: Double): Data131 = copy(value = value * k)
  def addTag(t: String): Data131 = copy(tags = t :: tags)
  def put(k: String, v: String): Data131 = copy(meta = meta.updated(k, v))
  def merge(other: Data131): Data131 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data131 {
  given Ordering[Data131] = Ordering.by(_.id)
  def empty: Data131 = Data131(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data131 =
    Data131(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data131] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
