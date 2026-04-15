package generated

final case class Data40(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data40 = copy(name = name.toUpperCase)
  def scale(k: Double): Data40 = copy(value = value * k)
  def addTag(t: String): Data40 = copy(tags = t :: tags)
  def put(k: String, v: String): Data40 = copy(meta = meta.updated(k, v))
  def merge(other: Data40): Data40 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data40 {
  given Ordering[Data40] = Ordering.by(_.id)
  def empty: Data40 = Data40(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data40 =
    Data40(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data40] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
