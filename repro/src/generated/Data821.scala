package generated

final case class Data821(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data821 = copy(name = name.toUpperCase)
  def scale(k: Double): Data821 = copy(value = value * k)
  def addTag(t: String): Data821 = copy(tags = t :: tags)
  def put(k: String, v: String): Data821 = copy(meta = meta.updated(k, v))
  def merge(other: Data821): Data821 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data821 {
  given Ordering[Data821] = Ordering.by(_.id)
  def empty: Data821 = Data821(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data821 =
    Data821(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data821] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
