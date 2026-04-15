package generated

final case class Data252(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data252 = copy(name = name.toUpperCase)
  def scale(k: Double): Data252 = copy(value = value * k)
  def addTag(t: String): Data252 = copy(tags = t :: tags)
  def put(k: String, v: String): Data252 = copy(meta = meta.updated(k, v))
  def merge(other: Data252): Data252 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data252 {
  given Ordering[Data252] = Ordering.by(_.id)
  def empty: Data252 = Data252(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data252 =
    Data252(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data252] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
