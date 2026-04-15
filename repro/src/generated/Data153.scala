package generated

final case class Data153(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data153 = copy(name = name.toUpperCase)
  def scale(k: Double): Data153 = copy(value = value * k)
  def addTag(t: String): Data153 = copy(tags = t :: tags)
  def put(k: String, v: String): Data153 = copy(meta = meta.updated(k, v))
  def merge(other: Data153): Data153 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data153 {
  given Ordering[Data153] = Ordering.by(_.id)
  def empty: Data153 = Data153(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data153 =
    Data153(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data153] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
