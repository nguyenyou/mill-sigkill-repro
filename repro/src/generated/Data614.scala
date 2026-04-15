package generated

final case class Data614(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data614 = copy(name = name.toUpperCase)
  def scale(k: Double): Data614 = copy(value = value * k)
  def addTag(t: String): Data614 = copy(tags = t :: tags)
  def put(k: String, v: String): Data614 = copy(meta = meta.updated(k, v))
  def merge(other: Data614): Data614 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data614 {
  given Ordering[Data614] = Ordering.by(_.id)
  def empty: Data614 = Data614(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data614 =
    Data614(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data614] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
