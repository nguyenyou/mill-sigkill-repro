package generated

final case class Data334(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data334 = copy(name = name.toUpperCase)
  def scale(k: Double): Data334 = copy(value = value * k)
  def addTag(t: String): Data334 = copy(tags = t :: tags)
  def put(k: String, v: String): Data334 = copy(meta = meta.updated(k, v))
  def merge(other: Data334): Data334 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data334 {
  given Ordering[Data334] = Ordering.by(_.id)
  def empty: Data334 = Data334(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data334 =
    Data334(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data334] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
