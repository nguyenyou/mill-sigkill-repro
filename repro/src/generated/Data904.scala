package generated

final case class Data904(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data904 = copy(name = name.toUpperCase)
  def scale(k: Double): Data904 = copy(value = value * k)
  def addTag(t: String): Data904 = copy(tags = t :: tags)
  def put(k: String, v: String): Data904 = copy(meta = meta.updated(k, v))
  def merge(other: Data904): Data904 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data904 {
  given Ordering[Data904] = Ordering.by(_.id)
  def empty: Data904 = Data904(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data904 =
    Data904(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data904] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
