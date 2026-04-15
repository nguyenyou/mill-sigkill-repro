package generated

final case class Data923(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data923 = copy(name = name.toUpperCase)
  def scale(k: Double): Data923 = copy(value = value * k)
  def addTag(t: String): Data923 = copy(tags = t :: tags)
  def put(k: String, v: String): Data923 = copy(meta = meta.updated(k, v))
  def merge(other: Data923): Data923 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data923 {
  given Ordering[Data923] = Ordering.by(_.id)
  def empty: Data923 = Data923(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data923 =
    Data923(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data923] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
