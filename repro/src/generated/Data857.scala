package generated

final case class Data857(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data857 = copy(name = name.toUpperCase)
  def scale(k: Double): Data857 = copy(value = value * k)
  def addTag(t: String): Data857 = copy(tags = t :: tags)
  def put(k: String, v: String): Data857 = copy(meta = meta.updated(k, v))
  def merge(other: Data857): Data857 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data857 {
  given Ordering[Data857] = Ordering.by(_.id)
  def empty: Data857 = Data857(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data857 =
    Data857(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data857] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
