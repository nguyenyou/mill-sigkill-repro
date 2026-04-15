package generated

final case class Data521(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data521 = copy(name = name.toUpperCase)
  def scale(k: Double): Data521 = copy(value = value * k)
  def addTag(t: String): Data521 = copy(tags = t :: tags)
  def put(k: String, v: String): Data521 = copy(meta = meta.updated(k, v))
  def merge(other: Data521): Data521 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data521 {
  given Ordering[Data521] = Ordering.by(_.id)
  def empty: Data521 = Data521(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data521 =
    Data521(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data521] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
