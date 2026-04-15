package generated

final case class Data27(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data27 = copy(name = name.toUpperCase)
  def scale(k: Double): Data27 = copy(value = value * k)
  def addTag(t: String): Data27 = copy(tags = t :: tags)
  def put(k: String, v: String): Data27 = copy(meta = meta.updated(k, v))
  def merge(other: Data27): Data27 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data27 {
  given Ordering[Data27] = Ordering.by(_.id)
  def empty: Data27 = Data27(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data27 =
    Data27(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data27] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
