package generated

final case class Data347(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data347 = copy(name = name.toUpperCase)
  def scale(k: Double): Data347 = copy(value = value * k)
  def addTag(t: String): Data347 = copy(tags = t :: tags)
  def put(k: String, v: String): Data347 = copy(meta = meta.updated(k, v))
  def merge(other: Data347): Data347 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data347 {
  given Ordering[Data347] = Ordering.by(_.id)
  def empty: Data347 = Data347(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data347 =
    Data347(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data347] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
