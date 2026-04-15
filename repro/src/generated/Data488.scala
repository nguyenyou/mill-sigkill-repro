package generated

final case class Data488(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data488 = copy(name = name.toUpperCase)
  def scale(k: Double): Data488 = copy(value = value * k)
  def addTag(t: String): Data488 = copy(tags = t :: tags)
  def put(k: String, v: String): Data488 = copy(meta = meta.updated(k, v))
  def merge(other: Data488): Data488 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data488 {
  given Ordering[Data488] = Ordering.by(_.id)
  def empty: Data488 = Data488(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data488 =
    Data488(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data488] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
