package generated

final case class Data560(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data560 = copy(name = name.toUpperCase)
  def scale(k: Double): Data560 = copy(value = value * k)
  def addTag(t: String): Data560 = copy(tags = t :: tags)
  def put(k: String, v: String): Data560 = copy(meta = meta.updated(k, v))
  def merge(other: Data560): Data560 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data560 {
  given Ordering[Data560] = Ordering.by(_.id)
  def empty: Data560 = Data560(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data560 =
    Data560(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data560] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
