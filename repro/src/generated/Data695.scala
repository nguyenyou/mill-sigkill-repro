package generated

final case class Data695(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data695 = copy(name = name.toUpperCase)
  def scale(k: Double): Data695 = copy(value = value * k)
  def addTag(t: String): Data695 = copy(tags = t :: tags)
  def put(k: String, v: String): Data695 = copy(meta = meta.updated(k, v))
  def merge(other: Data695): Data695 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data695 {
  given Ordering[Data695] = Ordering.by(_.id)
  def empty: Data695 = Data695(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data695 =
    Data695(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data695] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
