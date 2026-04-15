package generated

final case class Data1365(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1365 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1365 = copy(value = value * k)
  def addTag(t: String): Data1365 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1365 = copy(meta = meta.updated(k, v))
  def merge(other: Data1365): Data1365 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1365 {
  given Ordering[Data1365] = Ordering.by(_.id)
  def empty: Data1365 = Data1365(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1365 =
    Data1365(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1365] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
