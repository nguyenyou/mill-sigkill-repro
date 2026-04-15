package generated

final case class Data186(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data186 = copy(name = name.toUpperCase)
  def scale(k: Double): Data186 = copy(value = value * k)
  def addTag(t: String): Data186 = copy(tags = t :: tags)
  def put(k: String, v: String): Data186 = copy(meta = meta.updated(k, v))
  def merge(other: Data186): Data186 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data186 {
  given Ordering[Data186] = Ordering.by(_.id)
  def empty: Data186 = Data186(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data186 =
    Data186(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data186] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
