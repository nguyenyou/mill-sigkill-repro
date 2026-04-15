package generated

final case class Data816(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data816 = copy(name = name.toUpperCase)
  def scale(k: Double): Data816 = copy(value = value * k)
  def addTag(t: String): Data816 = copy(tags = t :: tags)
  def put(k: String, v: String): Data816 = copy(meta = meta.updated(k, v))
  def merge(other: Data816): Data816 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data816 {
  given Ordering[Data816] = Ordering.by(_.id)
  def empty: Data816 = Data816(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data816 =
    Data816(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data816] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
