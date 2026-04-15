package generated

final case class Data770(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data770 = copy(name = name.toUpperCase)
  def scale(k: Double): Data770 = copy(value = value * k)
  def addTag(t: String): Data770 = copy(tags = t :: tags)
  def put(k: String, v: String): Data770 = copy(meta = meta.updated(k, v))
  def merge(other: Data770): Data770 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data770 {
  given Ordering[Data770] = Ordering.by(_.id)
  def empty: Data770 = Data770(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data770 =
    Data770(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data770] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
