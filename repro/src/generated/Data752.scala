package generated

final case class Data752(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data752 = copy(name = name.toUpperCase)
  def scale(k: Double): Data752 = copy(value = value * k)
  def addTag(t: String): Data752 = copy(tags = t :: tags)
  def put(k: String, v: String): Data752 = copy(meta = meta.updated(k, v))
  def merge(other: Data752): Data752 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data752 {
  given Ordering[Data752] = Ordering.by(_.id)
  def empty: Data752 = Data752(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data752 =
    Data752(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data752] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
