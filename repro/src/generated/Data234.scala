package generated

final case class Data234(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data234 = copy(name = name.toUpperCase)
  def scale(k: Double): Data234 = copy(value = value * k)
  def addTag(t: String): Data234 = copy(tags = t :: tags)
  def put(k: String, v: String): Data234 = copy(meta = meta.updated(k, v))
  def merge(other: Data234): Data234 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data234 {
  given Ordering[Data234] = Ordering.by(_.id)
  def empty: Data234 = Data234(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data234 =
    Data234(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data234] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
