package generated

final case class Data870(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data870 = copy(name = name.toUpperCase)
  def scale(k: Double): Data870 = copy(value = value * k)
  def addTag(t: String): Data870 = copy(tags = t :: tags)
  def put(k: String, v: String): Data870 = copy(meta = meta.updated(k, v))
  def merge(other: Data870): Data870 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data870 {
  given Ordering[Data870] = Ordering.by(_.id)
  def empty: Data870 = Data870(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data870 =
    Data870(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data870] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
