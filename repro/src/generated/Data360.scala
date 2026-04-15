package generated

final case class Data360(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data360 = copy(name = name.toUpperCase)
  def scale(k: Double): Data360 = copy(value = value * k)
  def addTag(t: String): Data360 = copy(tags = t :: tags)
  def put(k: String, v: String): Data360 = copy(meta = meta.updated(k, v))
  def merge(other: Data360): Data360 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data360 {
  given Ordering[Data360] = Ordering.by(_.id)
  def empty: Data360 = Data360(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data360 =
    Data360(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data360] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
