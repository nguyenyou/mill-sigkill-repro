package generated

final case class Data265(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data265 = copy(name = name.toUpperCase)
  def scale(k: Double): Data265 = copy(value = value * k)
  def addTag(t: String): Data265 = copy(tags = t :: tags)
  def put(k: String, v: String): Data265 = copy(meta = meta.updated(k, v))
  def merge(other: Data265): Data265 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data265 {
  given Ordering[Data265] = Ordering.by(_.id)
  def empty: Data265 = Data265(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data265 =
    Data265(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data265] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
