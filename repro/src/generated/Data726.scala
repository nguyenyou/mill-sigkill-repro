package generated

final case class Data726(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data726 = copy(name = name.toUpperCase)
  def scale(k: Double): Data726 = copy(value = value * k)
  def addTag(t: String): Data726 = copy(tags = t :: tags)
  def put(k: String, v: String): Data726 = copy(meta = meta.updated(k, v))
  def merge(other: Data726): Data726 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data726 {
  given Ordering[Data726] = Ordering.by(_.id)
  def empty: Data726 = Data726(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data726 =
    Data726(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data726] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
