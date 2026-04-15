package generated

final case class Data57(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data57 = copy(name = name.toUpperCase)
  def scale(k: Double): Data57 = copy(value = value * k)
  def addTag(t: String): Data57 = copy(tags = t :: tags)
  def put(k: String, v: String): Data57 = copy(meta = meta.updated(k, v))
  def merge(other: Data57): Data57 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data57 {
  given Ordering[Data57] = Ordering.by(_.id)
  def empty: Data57 = Data57(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data57 =
    Data57(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data57] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
