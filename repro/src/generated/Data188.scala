package generated

final case class Data188(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data188 = copy(name = name.toUpperCase)
  def scale(k: Double): Data188 = copy(value = value * k)
  def addTag(t: String): Data188 = copy(tags = t :: tags)
  def put(k: String, v: String): Data188 = copy(meta = meta.updated(k, v))
  def merge(other: Data188): Data188 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data188 {
  given Ordering[Data188] = Ordering.by(_.id)
  def empty: Data188 = Data188(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data188 =
    Data188(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data188] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
