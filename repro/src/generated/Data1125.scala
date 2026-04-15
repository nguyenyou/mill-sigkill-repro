package generated

final case class Data1125(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1125 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1125 = copy(value = value * k)
  def addTag(t: String): Data1125 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1125 = copy(meta = meta.updated(k, v))
  def merge(other: Data1125): Data1125 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1125 {
  given Ordering[Data1125] = Ordering.by(_.id)
  def empty: Data1125 = Data1125(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1125 =
    Data1125(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1125] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
