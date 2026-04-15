package generated

final case class Data313(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data313 = copy(name = name.toUpperCase)
  def scale(k: Double): Data313 = copy(value = value * k)
  def addTag(t: String): Data313 = copy(tags = t :: tags)
  def put(k: String, v: String): Data313 = copy(meta = meta.updated(k, v))
  def merge(other: Data313): Data313 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data313 {
  given Ordering[Data313] = Ordering.by(_.id)
  def empty: Data313 = Data313(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data313 =
    Data313(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data313] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
