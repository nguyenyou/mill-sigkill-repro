package generated

final case class Data1367(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1367 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1367 = copy(value = value * k)
  def addTag(t: String): Data1367 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1367 = copy(meta = meta.updated(k, v))
  def merge(other: Data1367): Data1367 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1367 {
  given Ordering[Data1367] = Ordering.by(_.id)
  def empty: Data1367 = Data1367(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1367 =
    Data1367(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1367] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
