package generated

final case class Data309(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data309 = copy(name = name.toUpperCase)
  def scale(k: Double): Data309 = copy(value = value * k)
  def addTag(t: String): Data309 = copy(tags = t :: tags)
  def put(k: String, v: String): Data309 = copy(meta = meta.updated(k, v))
  def merge(other: Data309): Data309 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data309 {
  given Ordering[Data309] = Ordering.by(_.id)
  def empty: Data309 = Data309(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data309 =
    Data309(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data309] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
