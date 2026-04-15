package generated

final case class Data172(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data172 = copy(name = name.toUpperCase)
  def scale(k: Double): Data172 = copy(value = value * k)
  def addTag(t: String): Data172 = copy(tags = t :: tags)
  def put(k: String, v: String): Data172 = copy(meta = meta.updated(k, v))
  def merge(other: Data172): Data172 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data172 {
  given Ordering[Data172] = Ordering.by(_.id)
  def empty: Data172 = Data172(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data172 =
    Data172(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data172] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
