package generated

final case class Data969(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data969 = copy(name = name.toUpperCase)
  def scale(k: Double): Data969 = copy(value = value * k)
  def addTag(t: String): Data969 = copy(tags = t :: tags)
  def put(k: String, v: String): Data969 = copy(meta = meta.updated(k, v))
  def merge(other: Data969): Data969 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data969 {
  given Ordering[Data969] = Ordering.by(_.id)
  def empty: Data969 = Data969(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data969 =
    Data969(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data969] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
