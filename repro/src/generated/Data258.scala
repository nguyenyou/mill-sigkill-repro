package generated

final case class Data258(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data258 = copy(name = name.toUpperCase)
  def scale(k: Double): Data258 = copy(value = value * k)
  def addTag(t: String): Data258 = copy(tags = t :: tags)
  def put(k: String, v: String): Data258 = copy(meta = meta.updated(k, v))
  def merge(other: Data258): Data258 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data258 {
  given Ordering[Data258] = Ordering.by(_.id)
  def empty: Data258 = Data258(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data258 =
    Data258(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data258] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
