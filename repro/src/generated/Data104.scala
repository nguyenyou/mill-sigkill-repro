package generated

final case class Data104(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data104 = copy(name = name.toUpperCase)
  def scale(k: Double): Data104 = copy(value = value * k)
  def addTag(t: String): Data104 = copy(tags = t :: tags)
  def put(k: String, v: String): Data104 = copy(meta = meta.updated(k, v))
  def merge(other: Data104): Data104 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data104 {
  given Ordering[Data104] = Ordering.by(_.id)
  def empty: Data104 = Data104(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data104 =
    Data104(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data104] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
