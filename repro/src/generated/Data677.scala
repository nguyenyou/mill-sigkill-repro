package generated

final case class Data677(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data677 = copy(name = name.toUpperCase)
  def scale(k: Double): Data677 = copy(value = value * k)
  def addTag(t: String): Data677 = copy(tags = t :: tags)
  def put(k: String, v: String): Data677 = copy(meta = meta.updated(k, v))
  def merge(other: Data677): Data677 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data677 {
  given Ordering[Data677] = Ordering.by(_.id)
  def empty: Data677 = Data677(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data677 =
    Data677(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data677] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
