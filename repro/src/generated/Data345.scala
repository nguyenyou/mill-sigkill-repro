package generated

final case class Data345(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data345 = copy(name = name.toUpperCase)
  def scale(k: Double): Data345 = copy(value = value * k)
  def addTag(t: String): Data345 = copy(tags = t :: tags)
  def put(k: String, v: String): Data345 = copy(meta = meta.updated(k, v))
  def merge(other: Data345): Data345 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data345 {
  given Ordering[Data345] = Ordering.by(_.id)
  def empty: Data345 = Data345(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data345 =
    Data345(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data345] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
