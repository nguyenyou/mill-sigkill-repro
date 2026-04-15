package generated

final case class Data1490(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1490 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1490 = copy(value = value * k)
  def addTag(t: String): Data1490 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1490 = copy(meta = meta.updated(k, v))
  def merge(other: Data1490): Data1490 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1490 {
  given Ordering[Data1490] = Ordering.by(_.id)
  def empty: Data1490 = Data1490(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1490 =
    Data1490(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1490] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
