package generated

final case class Data889(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data889 = copy(name = name.toUpperCase)
  def scale(k: Double): Data889 = copy(value = value * k)
  def addTag(t: String): Data889 = copy(tags = t :: tags)
  def put(k: String, v: String): Data889 = copy(meta = meta.updated(k, v))
  def merge(other: Data889): Data889 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data889 {
  given Ordering[Data889] = Ordering.by(_.id)
  def empty: Data889 = Data889(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data889 =
    Data889(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data889] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
