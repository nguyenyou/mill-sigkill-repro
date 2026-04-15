package generated

final case class Data762(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data762 = copy(name = name.toUpperCase)
  def scale(k: Double): Data762 = copy(value = value * k)
  def addTag(t: String): Data762 = copy(tags = t :: tags)
  def put(k: String, v: String): Data762 = copy(meta = meta.updated(k, v))
  def merge(other: Data762): Data762 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data762 {
  given Ordering[Data762] = Ordering.by(_.id)
  def empty: Data762 = Data762(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data762 =
    Data762(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data762] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
