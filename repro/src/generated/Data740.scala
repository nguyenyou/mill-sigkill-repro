package generated

final case class Data740(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data740 = copy(name = name.toUpperCase)
  def scale(k: Double): Data740 = copy(value = value * k)
  def addTag(t: String): Data740 = copy(tags = t :: tags)
  def put(k: String, v: String): Data740 = copy(meta = meta.updated(k, v))
  def merge(other: Data740): Data740 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data740 {
  given Ordering[Data740] = Ordering.by(_.id)
  def empty: Data740 = Data740(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data740 =
    Data740(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data740] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
