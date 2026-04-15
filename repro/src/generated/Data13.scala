package generated

final case class Data13(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data13 = copy(name = name.toUpperCase)
  def scale(k: Double): Data13 = copy(value = value * k)
  def addTag(t: String): Data13 = copy(tags = t :: tags)
  def put(k: String, v: String): Data13 = copy(meta = meta.updated(k, v))
  def merge(other: Data13): Data13 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data13 {
  given Ordering[Data13] = Ordering.by(_.id)
  def empty: Data13 = Data13(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data13 =
    Data13(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data13] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
