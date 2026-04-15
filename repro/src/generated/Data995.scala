package generated

final case class Data995(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data995 = copy(name = name.toUpperCase)
  def scale(k: Double): Data995 = copy(value = value * k)
  def addTag(t: String): Data995 = copy(tags = t :: tags)
  def put(k: String, v: String): Data995 = copy(meta = meta.updated(k, v))
  def merge(other: Data995): Data995 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data995 {
  given Ordering[Data995] = Ordering.by(_.id)
  def empty: Data995 = Data995(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data995 =
    Data995(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data995] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
