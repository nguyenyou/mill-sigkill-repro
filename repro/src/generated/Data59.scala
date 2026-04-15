package generated

final case class Data59(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data59 = copy(name = name.toUpperCase)
  def scale(k: Double): Data59 = copy(value = value * k)
  def addTag(t: String): Data59 = copy(tags = t :: tags)
  def put(k: String, v: String): Data59 = copy(meta = meta.updated(k, v))
  def merge(other: Data59): Data59 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data59 {
  given Ordering[Data59] = Ordering.by(_.id)
  def empty: Data59 = Data59(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data59 =
    Data59(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data59] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
