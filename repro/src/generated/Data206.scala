package generated

final case class Data206(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data206 = copy(name = name.toUpperCase)
  def scale(k: Double): Data206 = copy(value = value * k)
  def addTag(t: String): Data206 = copy(tags = t :: tags)
  def put(k: String, v: String): Data206 = copy(meta = meta.updated(k, v))
  def merge(other: Data206): Data206 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data206 {
  given Ordering[Data206] = Ordering.by(_.id)
  def empty: Data206 = Data206(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data206 =
    Data206(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data206] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
