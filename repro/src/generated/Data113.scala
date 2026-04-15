package generated

final case class Data113(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data113 = copy(name = name.toUpperCase)
  def scale(k: Double): Data113 = copy(value = value * k)
  def addTag(t: String): Data113 = copy(tags = t :: tags)
  def put(k: String, v: String): Data113 = copy(meta = meta.updated(k, v))
  def merge(other: Data113): Data113 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data113 {
  given Ordering[Data113] = Ordering.by(_.id)
  def empty: Data113 = Data113(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data113 =
    Data113(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data113] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
