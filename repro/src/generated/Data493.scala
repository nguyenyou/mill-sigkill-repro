package generated

final case class Data493(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data493 = copy(name = name.toUpperCase)
  def scale(k: Double): Data493 = copy(value = value * k)
  def addTag(t: String): Data493 = copy(tags = t :: tags)
  def put(k: String, v: String): Data493 = copy(meta = meta.updated(k, v))
  def merge(other: Data493): Data493 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data493 {
  given Ordering[Data493] = Ordering.by(_.id)
  def empty: Data493 = Data493(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data493 =
    Data493(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data493] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
