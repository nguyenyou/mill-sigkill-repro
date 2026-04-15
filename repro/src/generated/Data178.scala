package generated

final case class Data178(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data178 = copy(name = name.toUpperCase)
  def scale(k: Double): Data178 = copy(value = value * k)
  def addTag(t: String): Data178 = copy(tags = t :: tags)
  def put(k: String, v: String): Data178 = copy(meta = meta.updated(k, v))
  def merge(other: Data178): Data178 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data178 {
  given Ordering[Data178] = Ordering.by(_.id)
  def empty: Data178 = Data178(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data178 =
    Data178(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data178] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
