package generated

final case class Data1419(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1419 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1419 = copy(value = value * k)
  def addTag(t: String): Data1419 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1419 = copy(meta = meta.updated(k, v))
  def merge(other: Data1419): Data1419 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1419 {
  given Ordering[Data1419] = Ordering.by(_.id)
  def empty: Data1419 = Data1419(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1419 =
    Data1419(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1419] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
