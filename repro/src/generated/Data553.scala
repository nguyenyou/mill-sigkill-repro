package generated

final case class Data553(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data553 = copy(name = name.toUpperCase)
  def scale(k: Double): Data553 = copy(value = value * k)
  def addTag(t: String): Data553 = copy(tags = t :: tags)
  def put(k: String, v: String): Data553 = copy(meta = meta.updated(k, v))
  def merge(other: Data553): Data553 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data553 {
  given Ordering[Data553] = Ordering.by(_.id)
  def empty: Data553 = Data553(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data553 =
    Data553(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data553] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
