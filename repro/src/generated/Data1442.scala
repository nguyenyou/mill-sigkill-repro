package generated

final case class Data1442(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1442 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1442 = copy(value = value * k)
  def addTag(t: String): Data1442 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1442 = copy(meta = meta.updated(k, v))
  def merge(other: Data1442): Data1442 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1442 {
  given Ordering[Data1442] = Ordering.by(_.id)
  def empty: Data1442 = Data1442(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1442 =
    Data1442(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1442] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
