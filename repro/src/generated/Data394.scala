package generated

final case class Data394(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data394 = copy(name = name.toUpperCase)
  def scale(k: Double): Data394 = copy(value = value * k)
  def addTag(t: String): Data394 = copy(tags = t :: tags)
  def put(k: String, v: String): Data394 = copy(meta = meta.updated(k, v))
  def merge(other: Data394): Data394 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data394 {
  given Ordering[Data394] = Ordering.by(_.id)
  def empty: Data394 = Data394(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data394 =
    Data394(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data394] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
