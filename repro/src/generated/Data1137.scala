package generated

final case class Data1137(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1137 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1137 = copy(value = value * k)
  def addTag(t: String): Data1137 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1137 = copy(meta = meta.updated(k, v))
  def merge(other: Data1137): Data1137 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1137 {
  given Ordering[Data1137] = Ordering.by(_.id)
  def empty: Data1137 = Data1137(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1137 =
    Data1137(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1137] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
