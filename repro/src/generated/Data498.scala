package generated

final case class Data498(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data498 = copy(name = name.toUpperCase)
  def scale(k: Double): Data498 = copy(value = value * k)
  def addTag(t: String): Data498 = copy(tags = t :: tags)
  def put(k: String, v: String): Data498 = copy(meta = meta.updated(k, v))
  def merge(other: Data498): Data498 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data498 {
  given Ordering[Data498] = Ordering.by(_.id)
  def empty: Data498 = Data498(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data498 =
    Data498(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data498] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
