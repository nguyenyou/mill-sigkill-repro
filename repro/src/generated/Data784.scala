package generated

final case class Data784(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data784 = copy(name = name.toUpperCase)
  def scale(k: Double): Data784 = copy(value = value * k)
  def addTag(t: String): Data784 = copy(tags = t :: tags)
  def put(k: String, v: String): Data784 = copy(meta = meta.updated(k, v))
  def merge(other: Data784): Data784 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data784 {
  given Ordering[Data784] = Ordering.by(_.id)
  def empty: Data784 = Data784(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data784 =
    Data784(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data784] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
