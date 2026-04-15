package generated

final case class Data538(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data538 = copy(name = name.toUpperCase)
  def scale(k: Double): Data538 = copy(value = value * k)
  def addTag(t: String): Data538 = copy(tags = t :: tags)
  def put(k: String, v: String): Data538 = copy(meta = meta.updated(k, v))
  def merge(other: Data538): Data538 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data538 {
  given Ordering[Data538] = Ordering.by(_.id)
  def empty: Data538 = Data538(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data538 =
    Data538(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data538] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
