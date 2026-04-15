package generated

final case class Data71(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data71 = copy(name = name.toUpperCase)
  def scale(k: Double): Data71 = copy(value = value * k)
  def addTag(t: String): Data71 = copy(tags = t :: tags)
  def put(k: String, v: String): Data71 = copy(meta = meta.updated(k, v))
  def merge(other: Data71): Data71 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data71 {
  given Ordering[Data71] = Ordering.by(_.id)
  def empty: Data71 = Data71(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data71 =
    Data71(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data71] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
