package generated

final case class Data256(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data256 = copy(name = name.toUpperCase)
  def scale(k: Double): Data256 = copy(value = value * k)
  def addTag(t: String): Data256 = copy(tags = t :: tags)
  def put(k: String, v: String): Data256 = copy(meta = meta.updated(k, v))
  def merge(other: Data256): Data256 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data256 {
  given Ordering[Data256] = Ordering.by(_.id)
  def empty: Data256 = Data256(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data256 =
    Data256(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data256] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
