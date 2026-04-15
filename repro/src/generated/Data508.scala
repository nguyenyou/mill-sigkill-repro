package generated

final case class Data508(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data508 = copy(name = name.toUpperCase)
  def scale(k: Double): Data508 = copy(value = value * k)
  def addTag(t: String): Data508 = copy(tags = t :: tags)
  def put(k: String, v: String): Data508 = copy(meta = meta.updated(k, v))
  def merge(other: Data508): Data508 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data508 {
  given Ordering[Data508] = Ordering.by(_.id)
  def empty: Data508 = Data508(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data508 =
    Data508(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data508] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
