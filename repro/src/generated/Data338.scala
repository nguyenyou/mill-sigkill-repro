package generated

final case class Data338(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data338 = copy(name = name.toUpperCase)
  def scale(k: Double): Data338 = copy(value = value * k)
  def addTag(t: String): Data338 = copy(tags = t :: tags)
  def put(k: String, v: String): Data338 = copy(meta = meta.updated(k, v))
  def merge(other: Data338): Data338 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data338 {
  given Ordering[Data338] = Ordering.by(_.id)
  def empty: Data338 = Data338(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data338 =
    Data338(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data338] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
