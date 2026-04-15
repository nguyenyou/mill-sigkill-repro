package generated

final case class Data557(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data557 = copy(name = name.toUpperCase)
  def scale(k: Double): Data557 = copy(value = value * k)
  def addTag(t: String): Data557 = copy(tags = t :: tags)
  def put(k: String, v: String): Data557 = copy(meta = meta.updated(k, v))
  def merge(other: Data557): Data557 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data557 {
  given Ordering[Data557] = Ordering.by(_.id)
  def empty: Data557 = Data557(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data557 =
    Data557(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data557] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
