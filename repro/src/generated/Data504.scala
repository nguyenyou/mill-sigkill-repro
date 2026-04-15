package generated

final case class Data504(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data504 = copy(name = name.toUpperCase)
  def scale(k: Double): Data504 = copy(value = value * k)
  def addTag(t: String): Data504 = copy(tags = t :: tags)
  def put(k: String, v: String): Data504 = copy(meta = meta.updated(k, v))
  def merge(other: Data504): Data504 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data504 {
  given Ordering[Data504] = Ordering.by(_.id)
  def empty: Data504 = Data504(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data504 =
    Data504(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data504] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
