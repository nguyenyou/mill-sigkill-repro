package generated

final case class Data381(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data381 = copy(name = name.toUpperCase)
  def scale(k: Double): Data381 = copy(value = value * k)
  def addTag(t: String): Data381 = copy(tags = t :: tags)
  def put(k: String, v: String): Data381 = copy(meta = meta.updated(k, v))
  def merge(other: Data381): Data381 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data381 {
  given Ordering[Data381] = Ordering.by(_.id)
  def empty: Data381 = Data381(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data381 =
    Data381(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data381] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
