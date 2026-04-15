package generated

final case class Data262(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data262 = copy(name = name.toUpperCase)
  def scale(k: Double): Data262 = copy(value = value * k)
  def addTag(t: String): Data262 = copy(tags = t :: tags)
  def put(k: String, v: String): Data262 = copy(meta = meta.updated(k, v))
  def merge(other: Data262): Data262 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data262 {
  given Ordering[Data262] = Ordering.by(_.id)
  def empty: Data262 = Data262(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data262 =
    Data262(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data262] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
