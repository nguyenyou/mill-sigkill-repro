package generated

final case class Data810(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data810 = copy(name = name.toUpperCase)
  def scale(k: Double): Data810 = copy(value = value * k)
  def addTag(t: String): Data810 = copy(tags = t :: tags)
  def put(k: String, v: String): Data810 = copy(meta = meta.updated(k, v))
  def merge(other: Data810): Data810 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data810 {
  given Ordering[Data810] = Ordering.by(_.id)
  def empty: Data810 = Data810(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data810 =
    Data810(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data810] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
