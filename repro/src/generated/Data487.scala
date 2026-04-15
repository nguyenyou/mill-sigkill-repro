package generated

final case class Data487(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data487 = copy(name = name.toUpperCase)
  def scale(k: Double): Data487 = copy(value = value * k)
  def addTag(t: String): Data487 = copy(tags = t :: tags)
  def put(k: String, v: String): Data487 = copy(meta = meta.updated(k, v))
  def merge(other: Data487): Data487 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data487 {
  given Ordering[Data487] = Ordering.by(_.id)
  def empty: Data487 = Data487(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data487 =
    Data487(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data487] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
