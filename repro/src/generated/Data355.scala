package generated

final case class Data355(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data355 = copy(name = name.toUpperCase)
  def scale(k: Double): Data355 = copy(value = value * k)
  def addTag(t: String): Data355 = copy(tags = t :: tags)
  def put(k: String, v: String): Data355 = copy(meta = meta.updated(k, v))
  def merge(other: Data355): Data355 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data355 {
  given Ordering[Data355] = Ordering.by(_.id)
  def empty: Data355 = Data355(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data355 =
    Data355(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data355] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
