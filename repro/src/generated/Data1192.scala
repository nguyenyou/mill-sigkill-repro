package generated

final case class Data1192(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1192 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1192 = copy(value = value * k)
  def addTag(t: String): Data1192 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1192 = copy(meta = meta.updated(k, v))
  def merge(other: Data1192): Data1192 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1192 {
  given Ordering[Data1192] = Ordering.by(_.id)
  def empty: Data1192 = Data1192(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1192 =
    Data1192(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1192] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
