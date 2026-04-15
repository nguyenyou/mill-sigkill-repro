package generated

final case class Data579(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data579 = copy(name = name.toUpperCase)
  def scale(k: Double): Data579 = copy(value = value * k)
  def addTag(t: String): Data579 = copy(tags = t :: tags)
  def put(k: String, v: String): Data579 = copy(meta = meta.updated(k, v))
  def merge(other: Data579): Data579 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data579 {
  given Ordering[Data579] = Ordering.by(_.id)
  def empty: Data579 = Data579(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data579 =
    Data579(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data579] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
