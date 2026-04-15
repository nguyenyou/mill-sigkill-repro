package generated

final case class Data397(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data397 = copy(name = name.toUpperCase)
  def scale(k: Double): Data397 = copy(value = value * k)
  def addTag(t: String): Data397 = copy(tags = t :: tags)
  def put(k: String, v: String): Data397 = copy(meta = meta.updated(k, v))
  def merge(other: Data397): Data397 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data397 {
  given Ordering[Data397] = Ordering.by(_.id)
  def empty: Data397 = Data397(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data397 =
    Data397(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data397] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
