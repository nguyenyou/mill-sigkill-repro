package generated

final case class Data61(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data61 = copy(name = name.toUpperCase)
  def scale(k: Double): Data61 = copy(value = value * k)
  def addTag(t: String): Data61 = copy(tags = t :: tags)
  def put(k: String, v: String): Data61 = copy(meta = meta.updated(k, v))
  def merge(other: Data61): Data61 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data61 {
  given Ordering[Data61] = Ordering.by(_.id)
  def empty: Data61 = Data61(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data61 =
    Data61(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data61] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
