package generated

final case class Data380(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data380 = copy(name = name.toUpperCase)
  def scale(k: Double): Data380 = copy(value = value * k)
  def addTag(t: String): Data380 = copy(tags = t :: tags)
  def put(k: String, v: String): Data380 = copy(meta = meta.updated(k, v))
  def merge(other: Data380): Data380 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data380 {
  given Ordering[Data380] = Ordering.by(_.id)
  def empty: Data380 = Data380(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data380 =
    Data380(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data380] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
