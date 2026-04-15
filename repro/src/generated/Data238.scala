package generated

final case class Data238(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data238 = copy(name = name.toUpperCase)
  def scale(k: Double): Data238 = copy(value = value * k)
  def addTag(t: String): Data238 = copy(tags = t :: tags)
  def put(k: String, v: String): Data238 = copy(meta = meta.updated(k, v))
  def merge(other: Data238): Data238 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data238 {
  given Ordering[Data238] = Ordering.by(_.id)
  def empty: Data238 = Data238(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data238 =
    Data238(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data238] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
