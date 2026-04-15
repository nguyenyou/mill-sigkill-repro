package generated

final case class Data920(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data920 = copy(name = name.toUpperCase)
  def scale(k: Double): Data920 = copy(value = value * k)
  def addTag(t: String): Data920 = copy(tags = t :: tags)
  def put(k: String, v: String): Data920 = copy(meta = meta.updated(k, v))
  def merge(other: Data920): Data920 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data920 {
  given Ordering[Data920] = Ordering.by(_.id)
  def empty: Data920 = Data920(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data920 =
    Data920(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data920] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
