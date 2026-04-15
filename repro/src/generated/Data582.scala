package generated

final case class Data582(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data582 = copy(name = name.toUpperCase)
  def scale(k: Double): Data582 = copy(value = value * k)
  def addTag(t: String): Data582 = copy(tags = t :: tags)
  def put(k: String, v: String): Data582 = copy(meta = meta.updated(k, v))
  def merge(other: Data582): Data582 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data582 {
  given Ordering[Data582] = Ordering.by(_.id)
  def empty: Data582 = Data582(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data582 =
    Data582(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data582] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
