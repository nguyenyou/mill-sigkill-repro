package generated

final case class Data453(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data453 = copy(name = name.toUpperCase)
  def scale(k: Double): Data453 = copy(value = value * k)
  def addTag(t: String): Data453 = copy(tags = t :: tags)
  def put(k: String, v: String): Data453 = copy(meta = meta.updated(k, v))
  def merge(other: Data453): Data453 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data453 {
  given Ordering[Data453] = Ordering.by(_.id)
  def empty: Data453 = Data453(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data453 =
    Data453(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data453] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
