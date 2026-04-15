package generated

final case class Data1128(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1128 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1128 = copy(value = value * k)
  def addTag(t: String): Data1128 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1128 = copy(meta = meta.updated(k, v))
  def merge(other: Data1128): Data1128 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1128 {
  given Ordering[Data1128] = Ordering.by(_.id)
  def empty: Data1128 = Data1128(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1128 =
    Data1128(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1128] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
