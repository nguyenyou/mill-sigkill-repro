package generated

final case class Data1270(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1270 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1270 = copy(value = value * k)
  def addTag(t: String): Data1270 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1270 = copy(meta = meta.updated(k, v))
  def merge(other: Data1270): Data1270 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1270 {
  given Ordering[Data1270] = Ordering.by(_.id)
  def empty: Data1270 = Data1270(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1270 =
    Data1270(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1270] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
