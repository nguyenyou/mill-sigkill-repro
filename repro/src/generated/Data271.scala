package generated

final case class Data271(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data271 = copy(name = name.toUpperCase)
  def scale(k: Double): Data271 = copy(value = value * k)
  def addTag(t: String): Data271 = copy(tags = t :: tags)
  def put(k: String, v: String): Data271 = copy(meta = meta.updated(k, v))
  def merge(other: Data271): Data271 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data271 {
  given Ordering[Data271] = Ordering.by(_.id)
  def empty: Data271 = Data271(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data271 =
    Data271(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data271] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
