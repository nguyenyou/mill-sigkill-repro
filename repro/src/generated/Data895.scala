package generated

final case class Data895(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data895 = copy(name = name.toUpperCase)
  def scale(k: Double): Data895 = copy(value = value * k)
  def addTag(t: String): Data895 = copy(tags = t :: tags)
  def put(k: String, v: String): Data895 = copy(meta = meta.updated(k, v))
  def merge(other: Data895): Data895 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data895 {
  given Ordering[Data895] = Ordering.by(_.id)
  def empty: Data895 = Data895(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data895 =
    Data895(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data895] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
