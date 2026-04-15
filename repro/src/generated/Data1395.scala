package generated

final case class Data1395(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1395 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1395 = copy(value = value * k)
  def addTag(t: String): Data1395 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1395 = copy(meta = meta.updated(k, v))
  def merge(other: Data1395): Data1395 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1395 {
  given Ordering[Data1395] = Ordering.by(_.id)
  def empty: Data1395 = Data1395(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1395 =
    Data1395(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1395] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
