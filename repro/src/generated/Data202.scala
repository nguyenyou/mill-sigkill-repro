package generated

final case class Data202(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data202 = copy(name = name.toUpperCase)
  def scale(k: Double): Data202 = copy(value = value * k)
  def addTag(t: String): Data202 = copy(tags = t :: tags)
  def put(k: String, v: String): Data202 = copy(meta = meta.updated(k, v))
  def merge(other: Data202): Data202 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data202 {
  given Ordering[Data202] = Ordering.by(_.id)
  def empty: Data202 = Data202(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data202 =
    Data202(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data202] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
