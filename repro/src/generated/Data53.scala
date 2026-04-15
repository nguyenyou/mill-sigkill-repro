package generated

final case class Data53(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data53 = copy(name = name.toUpperCase)
  def scale(k: Double): Data53 = copy(value = value * k)
  def addTag(t: String): Data53 = copy(tags = t :: tags)
  def put(k: String, v: String): Data53 = copy(meta = meta.updated(k, v))
  def merge(other: Data53): Data53 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data53 {
  given Ordering[Data53] = Ordering.by(_.id)
  def empty: Data53 = Data53(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data53 =
    Data53(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data53] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
