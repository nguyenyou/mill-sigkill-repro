package generated

final case class Data689(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data689 = copy(name = name.toUpperCase)
  def scale(k: Double): Data689 = copy(value = value * k)
  def addTag(t: String): Data689 = copy(tags = t :: tags)
  def put(k: String, v: String): Data689 = copy(meta = meta.updated(k, v))
  def merge(other: Data689): Data689 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data689 {
  given Ordering[Data689] = Ordering.by(_.id)
  def empty: Data689 = Data689(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data689 =
    Data689(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data689] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
