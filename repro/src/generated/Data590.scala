package generated

final case class Data590(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data590 = copy(name = name.toUpperCase)
  def scale(k: Double): Data590 = copy(value = value * k)
  def addTag(t: String): Data590 = copy(tags = t :: tags)
  def put(k: String, v: String): Data590 = copy(meta = meta.updated(k, v))
  def merge(other: Data590): Data590 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data590 {
  given Ordering[Data590] = Ordering.by(_.id)
  def empty: Data590 = Data590(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data590 =
    Data590(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data590] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
