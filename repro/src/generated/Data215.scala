package generated

final case class Data215(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data215 = copy(name = name.toUpperCase)
  def scale(k: Double): Data215 = copy(value = value * k)
  def addTag(t: String): Data215 = copy(tags = t :: tags)
  def put(k: String, v: String): Data215 = copy(meta = meta.updated(k, v))
  def merge(other: Data215): Data215 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data215 {
  given Ordering[Data215] = Ordering.by(_.id)
  def empty: Data215 = Data215(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data215 =
    Data215(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data215] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
