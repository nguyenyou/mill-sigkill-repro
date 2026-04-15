package generated

final case class Data298(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data298 = copy(name = name.toUpperCase)
  def scale(k: Double): Data298 = copy(value = value * k)
  def addTag(t: String): Data298 = copy(tags = t :: tags)
  def put(k: String, v: String): Data298 = copy(meta = meta.updated(k, v))
  def merge(other: Data298): Data298 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data298 {
  given Ordering[Data298] = Ordering.by(_.id)
  def empty: Data298 = Data298(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data298 =
    Data298(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data298] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
