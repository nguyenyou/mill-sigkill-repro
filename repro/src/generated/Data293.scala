package generated

final case class Data293(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data293 = copy(name = name.toUpperCase)
  def scale(k: Double): Data293 = copy(value = value * k)
  def addTag(t: String): Data293 = copy(tags = t :: tags)
  def put(k: String, v: String): Data293 = copy(meta = meta.updated(k, v))
  def merge(other: Data293): Data293 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data293 {
  given Ordering[Data293] = Ordering.by(_.id)
  def empty: Data293 = Data293(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data293 =
    Data293(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data293] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
