package generated

final case class Data950(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data950 = copy(name = name.toUpperCase)
  def scale(k: Double): Data950 = copy(value = value * k)
  def addTag(t: String): Data950 = copy(tags = t :: tags)
  def put(k: String, v: String): Data950 = copy(meta = meta.updated(k, v))
  def merge(other: Data950): Data950 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data950 {
  given Ordering[Data950] = Ordering.by(_.id)
  def empty: Data950 = Data950(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data950 =
    Data950(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data950] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
