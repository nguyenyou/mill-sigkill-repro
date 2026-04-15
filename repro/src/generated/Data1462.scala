package generated

final case class Data1462(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1462 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1462 = copy(value = value * k)
  def addTag(t: String): Data1462 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1462 = copy(meta = meta.updated(k, v))
  def merge(other: Data1462): Data1462 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1462 {
  given Ordering[Data1462] = Ordering.by(_.id)
  def empty: Data1462 = Data1462(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1462 =
    Data1462(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1462] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
