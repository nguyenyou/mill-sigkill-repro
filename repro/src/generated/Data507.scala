package generated

final case class Data507(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data507 = copy(name = name.toUpperCase)
  def scale(k: Double): Data507 = copy(value = value * k)
  def addTag(t: String): Data507 = copy(tags = t :: tags)
  def put(k: String, v: String): Data507 = copy(meta = meta.updated(k, v))
  def merge(other: Data507): Data507 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data507 {
  given Ordering[Data507] = Ordering.by(_.id)
  def empty: Data507 = Data507(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data507 =
    Data507(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data507] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
