package generated

final case class Data232(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data232 = copy(name = name.toUpperCase)
  def scale(k: Double): Data232 = copy(value = value * k)
  def addTag(t: String): Data232 = copy(tags = t :: tags)
  def put(k: String, v: String): Data232 = copy(meta = meta.updated(k, v))
  def merge(other: Data232): Data232 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data232 {
  given Ordering[Data232] = Ordering.by(_.id)
  def empty: Data232 = Data232(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data232 =
    Data232(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data232] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
