package generated

final case class Data1165(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1165 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1165 = copy(value = value * k)
  def addTag(t: String): Data1165 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1165 = copy(meta = meta.updated(k, v))
  def merge(other: Data1165): Data1165 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1165 {
  given Ordering[Data1165] = Ordering.by(_.id)
  def empty: Data1165 = Data1165(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1165 =
    Data1165(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1165] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
