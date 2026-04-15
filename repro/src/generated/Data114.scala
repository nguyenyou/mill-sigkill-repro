package generated

final case class Data114(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data114 = copy(name = name.toUpperCase)
  def scale(k: Double): Data114 = copy(value = value * k)
  def addTag(t: String): Data114 = copy(tags = t :: tags)
  def put(k: String, v: String): Data114 = copy(meta = meta.updated(k, v))
  def merge(other: Data114): Data114 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data114 {
  given Ordering[Data114] = Ordering.by(_.id)
  def empty: Data114 = Data114(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data114 =
    Data114(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data114] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
