package generated

final case class Data1129(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1129 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1129 = copy(value = value * k)
  def addTag(t: String): Data1129 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1129 = copy(meta = meta.updated(k, v))
  def merge(other: Data1129): Data1129 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1129 {
  given Ordering[Data1129] = Ordering.by(_.id)
  def empty: Data1129 = Data1129(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1129 =
    Data1129(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1129] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
