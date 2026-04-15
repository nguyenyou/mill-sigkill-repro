package generated

final case class Data585(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data585 = copy(name = name.toUpperCase)
  def scale(k: Double): Data585 = copy(value = value * k)
  def addTag(t: String): Data585 = copy(tags = t :: tags)
  def put(k: String, v: String): Data585 = copy(meta = meta.updated(k, v))
  def merge(other: Data585): Data585 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data585 {
  given Ordering[Data585] = Ordering.by(_.id)
  def empty: Data585 = Data585(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data585 =
    Data585(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data585] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
