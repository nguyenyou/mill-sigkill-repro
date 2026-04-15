package generated

final case class Data1403(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1403 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1403 = copy(value = value * k)
  def addTag(t: String): Data1403 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1403 = copy(meta = meta.updated(k, v))
  def merge(other: Data1403): Data1403 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1403 {
  given Ordering[Data1403] = Ordering.by(_.id)
  def empty: Data1403 = Data1403(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1403 =
    Data1403(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1403] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
