package generated

final case class Data613(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data613 = copy(name = name.toUpperCase)
  def scale(k: Double): Data613 = copy(value = value * k)
  def addTag(t: String): Data613 = copy(tags = t :: tags)
  def put(k: String, v: String): Data613 = copy(meta = meta.updated(k, v))
  def merge(other: Data613): Data613 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data613 {
  given Ordering[Data613] = Ordering.by(_.id)
  def empty: Data613 = Data613(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data613 =
    Data613(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data613] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
