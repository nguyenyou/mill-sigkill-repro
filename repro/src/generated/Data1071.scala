package generated

final case class Data1071(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1071 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1071 = copy(value = value * k)
  def addTag(t: String): Data1071 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1071 = copy(meta = meta.updated(k, v))
  def merge(other: Data1071): Data1071 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1071 {
  given Ordering[Data1071] = Ordering.by(_.id)
  def empty: Data1071 = Data1071(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1071 =
    Data1071(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1071] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
