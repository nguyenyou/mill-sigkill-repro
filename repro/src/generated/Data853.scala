package generated

final case class Data853(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data853 = copy(name = name.toUpperCase)
  def scale(k: Double): Data853 = copy(value = value * k)
  def addTag(t: String): Data853 = copy(tags = t :: tags)
  def put(k: String, v: String): Data853 = copy(meta = meta.updated(k, v))
  def merge(other: Data853): Data853 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data853 {
  given Ordering[Data853] = Ordering.by(_.id)
  def empty: Data853 = Data853(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data853 =
    Data853(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data853] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
