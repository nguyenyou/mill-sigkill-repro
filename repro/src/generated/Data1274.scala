package generated

final case class Data1274(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1274 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1274 = copy(value = value * k)
  def addTag(t: String): Data1274 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1274 = copy(meta = meta.updated(k, v))
  def merge(other: Data1274): Data1274 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1274 {
  given Ordering[Data1274] = Ordering.by(_.id)
  def empty: Data1274 = Data1274(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1274 =
    Data1274(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1274] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
