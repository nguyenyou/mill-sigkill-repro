package generated

final case class Data155(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data155 = copy(name = name.toUpperCase)
  def scale(k: Double): Data155 = copy(value = value * k)
  def addTag(t: String): Data155 = copy(tags = t :: tags)
  def put(k: String, v: String): Data155 = copy(meta = meta.updated(k, v))
  def merge(other: Data155): Data155 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data155 {
  given Ordering[Data155] = Ordering.by(_.id)
  def empty: Data155 = Data155(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data155 =
    Data155(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data155] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
