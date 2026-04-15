package generated

final case class Data712(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data712 = copy(name = name.toUpperCase)
  def scale(k: Double): Data712 = copy(value = value * k)
  def addTag(t: String): Data712 = copy(tags = t :: tags)
  def put(k: String, v: String): Data712 = copy(meta = meta.updated(k, v))
  def merge(other: Data712): Data712 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data712 {
  given Ordering[Data712] = Ordering.by(_.id)
  def empty: Data712 = Data712(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data712 =
    Data712(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data712] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
