package generated

final case class Data73(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data73 = copy(name = name.toUpperCase)
  def scale(k: Double): Data73 = copy(value = value * k)
  def addTag(t: String): Data73 = copy(tags = t :: tags)
  def put(k: String, v: String): Data73 = copy(meta = meta.updated(k, v))
  def merge(other: Data73): Data73 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data73 {
  given Ordering[Data73] = Ordering.by(_.id)
  def empty: Data73 = Data73(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data73 =
    Data73(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data73] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
