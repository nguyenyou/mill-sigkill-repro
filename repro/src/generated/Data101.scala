package generated

final case class Data101(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data101 = copy(name = name.toUpperCase)
  def scale(k: Double): Data101 = copy(value = value * k)
  def addTag(t: String): Data101 = copy(tags = t :: tags)
  def put(k: String, v: String): Data101 = copy(meta = meta.updated(k, v))
  def merge(other: Data101): Data101 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data101 {
  given Ordering[Data101] = Ordering.by(_.id)
  def empty: Data101 = Data101(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data101 =
    Data101(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data101] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
