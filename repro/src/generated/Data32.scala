package generated

final case class Data32(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data32 = copy(name = name.toUpperCase)
  def scale(k: Double): Data32 = copy(value = value * k)
  def addTag(t: String): Data32 = copy(tags = t :: tags)
  def put(k: String, v: String): Data32 = copy(meta = meta.updated(k, v))
  def merge(other: Data32): Data32 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data32 {
  given Ordering[Data32] = Ordering.by(_.id)
  def empty: Data32 = Data32(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data32 =
    Data32(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data32] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
