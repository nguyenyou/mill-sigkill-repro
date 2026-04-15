package generated

final case class Data861(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data861 = copy(name = name.toUpperCase)
  def scale(k: Double): Data861 = copy(value = value * k)
  def addTag(t: String): Data861 = copy(tags = t :: tags)
  def put(k: String, v: String): Data861 = copy(meta = meta.updated(k, v))
  def merge(other: Data861): Data861 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data861 {
  given Ordering[Data861] = Ordering.by(_.id)
  def empty: Data861 = Data861(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data861 =
    Data861(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data861] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
