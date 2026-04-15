package generated

final case class Data314(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data314 = copy(name = name.toUpperCase)
  def scale(k: Double): Data314 = copy(value = value * k)
  def addTag(t: String): Data314 = copy(tags = t :: tags)
  def put(k: String, v: String): Data314 = copy(meta = meta.updated(k, v))
  def merge(other: Data314): Data314 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data314 {
  given Ordering[Data314] = Ordering.by(_.id)
  def empty: Data314 = Data314(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data314 =
    Data314(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data314] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
