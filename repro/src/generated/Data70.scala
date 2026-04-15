package generated

final case class Data70(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data70 = copy(name = name.toUpperCase)
  def scale(k: Double): Data70 = copy(value = value * k)
  def addTag(t: String): Data70 = copy(tags = t :: tags)
  def put(k: String, v: String): Data70 = copy(meta = meta.updated(k, v))
  def merge(other: Data70): Data70 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data70 {
  given Ordering[Data70] = Ordering.by(_.id)
  def empty: Data70 = Data70(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data70 =
    Data70(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data70] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
