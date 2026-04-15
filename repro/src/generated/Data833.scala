package generated

final case class Data833(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data833 = copy(name = name.toUpperCase)
  def scale(k: Double): Data833 = copy(value = value * k)
  def addTag(t: String): Data833 = copy(tags = t :: tags)
  def put(k: String, v: String): Data833 = copy(meta = meta.updated(k, v))
  def merge(other: Data833): Data833 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data833 {
  given Ordering[Data833] = Ordering.by(_.id)
  def empty: Data833 = Data833(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data833 =
    Data833(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data833] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
