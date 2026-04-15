package generated

final case class Data580(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data580 = copy(name = name.toUpperCase)
  def scale(k: Double): Data580 = copy(value = value * k)
  def addTag(t: String): Data580 = copy(tags = t :: tags)
  def put(k: String, v: String): Data580 = copy(meta = meta.updated(k, v))
  def merge(other: Data580): Data580 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data580 {
  given Ordering[Data580] = Ordering.by(_.id)
  def empty: Data580 = Data580(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data580 =
    Data580(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data580] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
