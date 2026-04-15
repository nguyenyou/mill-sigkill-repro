package generated

final case class Data416(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data416 = copy(name = name.toUpperCase)
  def scale(k: Double): Data416 = copy(value = value * k)
  def addTag(t: String): Data416 = copy(tags = t :: tags)
  def put(k: String, v: String): Data416 = copy(meta = meta.updated(k, v))
  def merge(other: Data416): Data416 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data416 {
  given Ordering[Data416] = Ordering.by(_.id)
  def empty: Data416 = Data416(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data416 =
    Data416(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data416] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
