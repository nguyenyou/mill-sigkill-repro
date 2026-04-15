package generated

final case class Data248(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data248 = copy(name = name.toUpperCase)
  def scale(k: Double): Data248 = copy(value = value * k)
  def addTag(t: String): Data248 = copy(tags = t :: tags)
  def put(k: String, v: String): Data248 = copy(meta = meta.updated(k, v))
  def merge(other: Data248): Data248 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data248 {
  given Ordering[Data248] = Ordering.by(_.id)
  def empty: Data248 = Data248(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data248 =
    Data248(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data248] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
