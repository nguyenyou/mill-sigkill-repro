package generated

final case class Data1281(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1281 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1281 = copy(value = value * k)
  def addTag(t: String): Data1281 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1281 = copy(meta = meta.updated(k, v))
  def merge(other: Data1281): Data1281 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1281 {
  given Ordering[Data1281] = Ordering.by(_.id)
  def empty: Data1281 = Data1281(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1281 =
    Data1281(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1281] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
