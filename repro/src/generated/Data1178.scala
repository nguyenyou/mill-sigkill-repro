package generated

final case class Data1178(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1178 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1178 = copy(value = value * k)
  def addTag(t: String): Data1178 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1178 = copy(meta = meta.updated(k, v))
  def merge(other: Data1178): Data1178 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1178 {
  given Ordering[Data1178] = Ordering.by(_.id)
  def empty: Data1178 = Data1178(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1178 =
    Data1178(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1178] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
