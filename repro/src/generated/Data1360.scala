package generated

final case class Data1360(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1360 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1360 = copy(value = value * k)
  def addTag(t: String): Data1360 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1360 = copy(meta = meta.updated(k, v))
  def merge(other: Data1360): Data1360 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1360 {
  given Ordering[Data1360] = Ordering.by(_.id)
  def empty: Data1360 = Data1360(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1360 =
    Data1360(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1360] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
