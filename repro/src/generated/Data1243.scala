package generated

final case class Data1243(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1243 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1243 = copy(value = value * k)
  def addTag(t: String): Data1243 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1243 = copy(meta = meta.updated(k, v))
  def merge(other: Data1243): Data1243 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1243 {
  given Ordering[Data1243] = Ordering.by(_.id)
  def empty: Data1243 = Data1243(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1243 =
    Data1243(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1243] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
