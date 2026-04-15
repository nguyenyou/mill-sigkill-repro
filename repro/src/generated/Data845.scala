package generated

final case class Data845(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data845 = copy(name = name.toUpperCase)
  def scale(k: Double): Data845 = copy(value = value * k)
  def addTag(t: String): Data845 = copy(tags = t :: tags)
  def put(k: String, v: String): Data845 = copy(meta = meta.updated(k, v))
  def merge(other: Data845): Data845 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data845 {
  given Ordering[Data845] = Ordering.by(_.id)
  def empty: Data845 = Data845(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data845 =
    Data845(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data845] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
