package generated

final case class Data542(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data542 = copy(name = name.toUpperCase)
  def scale(k: Double): Data542 = copy(value = value * k)
  def addTag(t: String): Data542 = copy(tags = t :: tags)
  def put(k: String, v: String): Data542 = copy(meta = meta.updated(k, v))
  def merge(other: Data542): Data542 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data542 {
  given Ordering[Data542] = Ordering.by(_.id)
  def empty: Data542 = Data542(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data542 =
    Data542(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data542] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
