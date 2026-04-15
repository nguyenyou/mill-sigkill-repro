package generated

final case class Data947(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data947 = copy(name = name.toUpperCase)
  def scale(k: Double): Data947 = copy(value = value * k)
  def addTag(t: String): Data947 = copy(tags = t :: tags)
  def put(k: String, v: String): Data947 = copy(meta = meta.updated(k, v))
  def merge(other: Data947): Data947 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data947 {
  given Ordering[Data947] = Ordering.by(_.id)
  def empty: Data947 = Data947(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data947 =
    Data947(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data947] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
