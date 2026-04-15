package generated

final case class Data332(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data332 = copy(name = name.toUpperCase)
  def scale(k: Double): Data332 = copy(value = value * k)
  def addTag(t: String): Data332 = copy(tags = t :: tags)
  def put(k: String, v: String): Data332 = copy(meta = meta.updated(k, v))
  def merge(other: Data332): Data332 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data332 {
  given Ordering[Data332] = Ordering.by(_.id)
  def empty: Data332 = Data332(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data332 =
    Data332(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data332] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
