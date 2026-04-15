package generated

final case class Data1435(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1435 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1435 = copy(value = value * k)
  def addTag(t: String): Data1435 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1435 = copy(meta = meta.updated(k, v))
  def merge(other: Data1435): Data1435 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1435 {
  given Ordering[Data1435] = Ordering.by(_.id)
  def empty: Data1435 = Data1435(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1435 =
    Data1435(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1435] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
