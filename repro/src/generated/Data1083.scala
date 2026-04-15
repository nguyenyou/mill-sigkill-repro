package generated

final case class Data1083(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1083 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1083 = copy(value = value * k)
  def addTag(t: String): Data1083 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1083 = copy(meta = meta.updated(k, v))
  def merge(other: Data1083): Data1083 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1083 {
  given Ordering[Data1083] = Ordering.by(_.id)
  def empty: Data1083 = Data1083(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1083 =
    Data1083(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1083] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
