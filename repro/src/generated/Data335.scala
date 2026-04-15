package generated

final case class Data335(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data335 = copy(name = name.toUpperCase)
  def scale(k: Double): Data335 = copy(value = value * k)
  def addTag(t: String): Data335 = copy(tags = t :: tags)
  def put(k: String, v: String): Data335 = copy(meta = meta.updated(k, v))
  def merge(other: Data335): Data335 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data335 {
  given Ordering[Data335] = Ordering.by(_.id)
  def empty: Data335 = Data335(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data335 =
    Data335(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data335] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
