package generated

final case class Data183(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data183 = copy(name = name.toUpperCase)
  def scale(k: Double): Data183 = copy(value = value * k)
  def addTag(t: String): Data183 = copy(tags = t :: tags)
  def put(k: String, v: String): Data183 = copy(meta = meta.updated(k, v))
  def merge(other: Data183): Data183 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data183 {
  given Ordering[Data183] = Ordering.by(_.id)
  def empty: Data183 = Data183(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data183 =
    Data183(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data183] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
