package generated

final case class Data351(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data351 = copy(name = name.toUpperCase)
  def scale(k: Double): Data351 = copy(value = value * k)
  def addTag(t: String): Data351 = copy(tags = t :: tags)
  def put(k: String, v: String): Data351 = copy(meta = meta.updated(k, v))
  def merge(other: Data351): Data351 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data351 {
  given Ordering[Data351] = Ordering.by(_.id)
  def empty: Data351 = Data351(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data351 =
    Data351(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data351] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
