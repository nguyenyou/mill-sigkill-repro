package generated

final case class Data305(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data305 = copy(name = name.toUpperCase)
  def scale(k: Double): Data305 = copy(value = value * k)
  def addTag(t: String): Data305 = copy(tags = t :: tags)
  def put(k: String, v: String): Data305 = copy(meta = meta.updated(k, v))
  def merge(other: Data305): Data305 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data305 {
  given Ordering[Data305] = Ordering.by(_.id)
  def empty: Data305 = Data305(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data305 =
    Data305(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data305] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
