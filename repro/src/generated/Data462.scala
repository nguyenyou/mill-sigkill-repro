package generated

final case class Data462(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data462 = copy(name = name.toUpperCase)
  def scale(k: Double): Data462 = copy(value = value * k)
  def addTag(t: String): Data462 = copy(tags = t :: tags)
  def put(k: String, v: String): Data462 = copy(meta = meta.updated(k, v))
  def merge(other: Data462): Data462 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data462 {
  given Ordering[Data462] = Ordering.by(_.id)
  def empty: Data462 = Data462(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data462 =
    Data462(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data462] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
