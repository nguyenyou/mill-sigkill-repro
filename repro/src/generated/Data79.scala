package generated

final case class Data79(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data79 = copy(name = name.toUpperCase)
  def scale(k: Double): Data79 = copy(value = value * k)
  def addTag(t: String): Data79 = copy(tags = t :: tags)
  def put(k: String, v: String): Data79 = copy(meta = meta.updated(k, v))
  def merge(other: Data79): Data79 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data79 {
  given Ordering[Data79] = Ordering.by(_.id)
  def empty: Data79 = Data79(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data79 =
    Data79(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data79] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
