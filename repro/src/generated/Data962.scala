package generated

final case class Data962(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data962 = copy(name = name.toUpperCase)
  def scale(k: Double): Data962 = copy(value = value * k)
  def addTag(t: String): Data962 = copy(tags = t :: tags)
  def put(k: String, v: String): Data962 = copy(meta = meta.updated(k, v))
  def merge(other: Data962): Data962 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data962 {
  given Ordering[Data962] = Ordering.by(_.id)
  def empty: Data962 = Data962(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data962 =
    Data962(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data962] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
