package generated

final case class Data799(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data799 = copy(name = name.toUpperCase)
  def scale(k: Double): Data799 = copy(value = value * k)
  def addTag(t: String): Data799 = copy(tags = t :: tags)
  def put(k: String, v: String): Data799 = copy(meta = meta.updated(k, v))
  def merge(other: Data799): Data799 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data799 {
  given Ordering[Data799] = Ordering.by(_.id)
  def empty: Data799 = Data799(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data799 =
    Data799(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data799] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
