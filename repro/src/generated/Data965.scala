package generated

final case class Data965(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data965 = copy(name = name.toUpperCase)
  def scale(k: Double): Data965 = copy(value = value * k)
  def addTag(t: String): Data965 = copy(tags = t :: tags)
  def put(k: String, v: String): Data965 = copy(meta = meta.updated(k, v))
  def merge(other: Data965): Data965 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data965 {
  given Ordering[Data965] = Ordering.by(_.id)
  def empty: Data965 = Data965(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data965 =
    Data965(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data965] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
