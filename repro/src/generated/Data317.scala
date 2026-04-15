package generated

final case class Data317(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data317 = copy(name = name.toUpperCase)
  def scale(k: Double): Data317 = copy(value = value * k)
  def addTag(t: String): Data317 = copy(tags = t :: tags)
  def put(k: String, v: String): Data317 = copy(meta = meta.updated(k, v))
  def merge(other: Data317): Data317 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data317 {
  given Ordering[Data317] = Ordering.by(_.id)
  def empty: Data317 = Data317(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data317 =
    Data317(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data317] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
