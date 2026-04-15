package generated

final case class Data134(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data134 = copy(name = name.toUpperCase)
  def scale(k: Double): Data134 = copy(value = value * k)
  def addTag(t: String): Data134 = copy(tags = t :: tags)
  def put(k: String, v: String): Data134 = copy(meta = meta.updated(k, v))
  def merge(other: Data134): Data134 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data134 {
  given Ordering[Data134] = Ordering.by(_.id)
  def empty: Data134 = Data134(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data134 =
    Data134(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data134] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
