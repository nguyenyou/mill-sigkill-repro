package generated

final case class Data918(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data918 = copy(name = name.toUpperCase)
  def scale(k: Double): Data918 = copy(value = value * k)
  def addTag(t: String): Data918 = copy(tags = t :: tags)
  def put(k: String, v: String): Data918 = copy(meta = meta.updated(k, v))
  def merge(other: Data918): Data918 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data918 {
  given Ordering[Data918] = Ordering.by(_.id)
  def empty: Data918 = Data918(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data918 =
    Data918(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data918] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
