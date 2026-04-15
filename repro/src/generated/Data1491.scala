package generated

final case class Data1491(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1491 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1491 = copy(value = value * k)
  def addTag(t: String): Data1491 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1491 = copy(meta = meta.updated(k, v))
  def merge(other: Data1491): Data1491 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1491 {
  given Ordering[Data1491] = Ordering.by(_.id)
  def empty: Data1491 = Data1491(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1491 =
    Data1491(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1491] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
