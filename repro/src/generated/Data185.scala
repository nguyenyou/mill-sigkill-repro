package generated

final case class Data185(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data185 = copy(name = name.toUpperCase)
  def scale(k: Double): Data185 = copy(value = value * k)
  def addTag(t: String): Data185 = copy(tags = t :: tags)
  def put(k: String, v: String): Data185 = copy(meta = meta.updated(k, v))
  def merge(other: Data185): Data185 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data185 {
  given Ordering[Data185] = Ordering.by(_.id)
  def empty: Data185 = Data185(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data185 =
    Data185(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data185] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
