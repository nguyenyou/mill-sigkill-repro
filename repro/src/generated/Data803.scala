package generated

final case class Data803(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data803 = copy(name = name.toUpperCase)
  def scale(k: Double): Data803 = copy(value = value * k)
  def addTag(t: String): Data803 = copy(tags = t :: tags)
  def put(k: String, v: String): Data803 = copy(meta = meta.updated(k, v))
  def merge(other: Data803): Data803 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data803 {
  given Ordering[Data803] = Ordering.by(_.id)
  def empty: Data803 = Data803(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data803 =
    Data803(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data803] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
