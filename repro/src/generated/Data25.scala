package generated

final case class Data25(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data25 = copy(name = name.toUpperCase)
  def scale(k: Double): Data25 = copy(value = value * k)
  def addTag(t: String): Data25 = copy(tags = t :: tags)
  def put(k: String, v: String): Data25 = copy(meta = meta.updated(k, v))
  def merge(other: Data25): Data25 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data25 {
  given Ordering[Data25] = Ordering.by(_.id)
  def empty: Data25 = Data25(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data25 =
    Data25(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data25] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
