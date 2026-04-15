package generated

final case class Data685(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data685 = copy(name = name.toUpperCase)
  def scale(k: Double): Data685 = copy(value = value * k)
  def addTag(t: String): Data685 = copy(tags = t :: tags)
  def put(k: String, v: String): Data685 = copy(meta = meta.updated(k, v))
  def merge(other: Data685): Data685 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data685 {
  given Ordering[Data685] = Ordering.by(_.id)
  def empty: Data685 = Data685(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data685 =
    Data685(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data685] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
