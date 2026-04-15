package generated

final case class Data103(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data103 = copy(name = name.toUpperCase)
  def scale(k: Double): Data103 = copy(value = value * k)
  def addTag(t: String): Data103 = copy(tags = t :: tags)
  def put(k: String, v: String): Data103 = copy(meta = meta.updated(k, v))
  def merge(other: Data103): Data103 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data103 {
  given Ordering[Data103] = Ordering.by(_.id)
  def empty: Data103 = Data103(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data103 =
    Data103(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data103] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
