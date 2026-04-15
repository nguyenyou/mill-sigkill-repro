package generated

final case class Data741(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data741 = copy(name = name.toUpperCase)
  def scale(k: Double): Data741 = copy(value = value * k)
  def addTag(t: String): Data741 = copy(tags = t :: tags)
  def put(k: String, v: String): Data741 = copy(meta = meta.updated(k, v))
  def merge(other: Data741): Data741 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data741 {
  given Ordering[Data741] = Ordering.by(_.id)
  def empty: Data741 = Data741(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data741 =
    Data741(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data741] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
