package generated

final case class Data546(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data546 = copy(name = name.toUpperCase)
  def scale(k: Double): Data546 = copy(value = value * k)
  def addTag(t: String): Data546 = copy(tags = t :: tags)
  def put(k: String, v: String): Data546 = copy(meta = meta.updated(k, v))
  def merge(other: Data546): Data546 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data546 {
  given Ordering[Data546] = Ordering.by(_.id)
  def empty: Data546 = Data546(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data546 =
    Data546(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data546] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
