package generated

final case class Data736(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data736 = copy(name = name.toUpperCase)
  def scale(k: Double): Data736 = copy(value = value * k)
  def addTag(t: String): Data736 = copy(tags = t :: tags)
  def put(k: String, v: String): Data736 = copy(meta = meta.updated(k, v))
  def merge(other: Data736): Data736 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data736 {
  given Ordering[Data736] = Ordering.by(_.id)
  def empty: Data736 = Data736(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data736 =
    Data736(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data736] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
