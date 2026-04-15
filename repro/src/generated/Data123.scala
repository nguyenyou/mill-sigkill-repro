package generated

final case class Data123(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data123 = copy(name = name.toUpperCase)
  def scale(k: Double): Data123 = copy(value = value * k)
  def addTag(t: String): Data123 = copy(tags = t :: tags)
  def put(k: String, v: String): Data123 = copy(meta = meta.updated(k, v))
  def merge(other: Data123): Data123 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data123 {
  given Ordering[Data123] = Ordering.by(_.id)
  def empty: Data123 = Data123(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data123 =
    Data123(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data123] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
