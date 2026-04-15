package generated

final case class Data50(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data50 = copy(name = name.toUpperCase)
  def scale(k: Double): Data50 = copy(value = value * k)
  def addTag(t: String): Data50 = copy(tags = t :: tags)
  def put(k: String, v: String): Data50 = copy(meta = meta.updated(k, v))
  def merge(other: Data50): Data50 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data50 {
  given Ordering[Data50] = Ordering.by(_.id)
  def empty: Data50 = Data50(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data50 =
    Data50(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data50] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
