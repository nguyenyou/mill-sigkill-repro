package generated

final case class Data478(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data478 = copy(name = name.toUpperCase)
  def scale(k: Double): Data478 = copy(value = value * k)
  def addTag(t: String): Data478 = copy(tags = t :: tags)
  def put(k: String, v: String): Data478 = copy(meta = meta.updated(k, v))
  def merge(other: Data478): Data478 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data478 {
  given Ordering[Data478] = Ordering.by(_.id)
  def empty: Data478 = Data478(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data478 =
    Data478(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data478] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
