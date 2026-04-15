package generated

final case class Data95(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data95 = copy(name = name.toUpperCase)
  def scale(k: Double): Data95 = copy(value = value * k)
  def addTag(t: String): Data95 = copy(tags = t :: tags)
  def put(k: String, v: String): Data95 = copy(meta = meta.updated(k, v))
  def merge(other: Data95): Data95 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data95 {
  given Ordering[Data95] = Ordering.by(_.id)
  def empty: Data95 = Data95(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data95 =
    Data95(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data95] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
