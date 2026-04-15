package generated

final case class Data435(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data435 = copy(name = name.toUpperCase)
  def scale(k: Double): Data435 = copy(value = value * k)
  def addTag(t: String): Data435 = copy(tags = t :: tags)
  def put(k: String, v: String): Data435 = copy(meta = meta.updated(k, v))
  def merge(other: Data435): Data435 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data435 {
  given Ordering[Data435] = Ordering.by(_.id)
  def empty: Data435 = Data435(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data435 =
    Data435(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data435] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
