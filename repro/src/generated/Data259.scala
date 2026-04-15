package generated

final case class Data259(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data259 = copy(name = name.toUpperCase)
  def scale(k: Double): Data259 = copy(value = value * k)
  def addTag(t: String): Data259 = copy(tags = t :: tags)
  def put(k: String, v: String): Data259 = copy(meta = meta.updated(k, v))
  def merge(other: Data259): Data259 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data259 {
  given Ordering[Data259] = Ordering.by(_.id)
  def empty: Data259 = Data259(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data259 =
    Data259(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data259] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
