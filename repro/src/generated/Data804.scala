package generated

final case class Data804(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data804 = copy(name = name.toUpperCase)
  def scale(k: Double): Data804 = copy(value = value * k)
  def addTag(t: String): Data804 = copy(tags = t :: tags)
  def put(k: String, v: String): Data804 = copy(meta = meta.updated(k, v))
  def merge(other: Data804): Data804 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data804 {
  given Ordering[Data804] = Ordering.by(_.id)
  def empty: Data804 = Data804(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data804 =
    Data804(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data804] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
