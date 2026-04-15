package generated

final case class Data408(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data408 = copy(name = name.toUpperCase)
  def scale(k: Double): Data408 = copy(value = value * k)
  def addTag(t: String): Data408 = copy(tags = t :: tags)
  def put(k: String, v: String): Data408 = copy(meta = meta.updated(k, v))
  def merge(other: Data408): Data408 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data408 {
  given Ordering[Data408] = Ordering.by(_.id)
  def empty: Data408 = Data408(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data408 =
    Data408(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data408] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
