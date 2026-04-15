package generated

final case class Data342(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data342 = copy(name = name.toUpperCase)
  def scale(k: Double): Data342 = copy(value = value * k)
  def addTag(t: String): Data342 = copy(tags = t :: tags)
  def put(k: String, v: String): Data342 = copy(meta = meta.updated(k, v))
  def merge(other: Data342): Data342 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data342 {
  given Ordering[Data342] = Ordering.by(_.id)
  def empty: Data342 = Data342(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data342 =
    Data342(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data342] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
