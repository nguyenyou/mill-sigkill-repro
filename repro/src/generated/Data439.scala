package generated

final case class Data439(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data439 = copy(name = name.toUpperCase)
  def scale(k: Double): Data439 = copy(value = value * k)
  def addTag(t: String): Data439 = copy(tags = t :: tags)
  def put(k: String, v: String): Data439 = copy(meta = meta.updated(k, v))
  def merge(other: Data439): Data439 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data439 {
  given Ordering[Data439] = Ordering.by(_.id)
  def empty: Data439 = Data439(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data439 =
    Data439(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data439] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
