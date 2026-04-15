package generated

final case class Data386(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data386 = copy(name = name.toUpperCase)
  def scale(k: Double): Data386 = copy(value = value * k)
  def addTag(t: String): Data386 = copy(tags = t :: tags)
  def put(k: String, v: String): Data386 = copy(meta = meta.updated(k, v))
  def merge(other: Data386): Data386 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data386 {
  given Ordering[Data386] = Ordering.by(_.id)
  def empty: Data386 = Data386(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data386 =
    Data386(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data386] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
