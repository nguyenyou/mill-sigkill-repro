package generated

final case class Data82(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data82 = copy(name = name.toUpperCase)
  def scale(k: Double): Data82 = copy(value = value * k)
  def addTag(t: String): Data82 = copy(tags = t :: tags)
  def put(k: String, v: String): Data82 = copy(meta = meta.updated(k, v))
  def merge(other: Data82): Data82 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data82 {
  given Ordering[Data82] = Ordering.by(_.id)
  def empty: Data82 = Data82(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data82 =
    Data82(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data82] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
