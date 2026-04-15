package generated

final case class Data771(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data771 = copy(name = name.toUpperCase)
  def scale(k: Double): Data771 = copy(value = value * k)
  def addTag(t: String): Data771 = copy(tags = t :: tags)
  def put(k: String, v: String): Data771 = copy(meta = meta.updated(k, v))
  def merge(other: Data771): Data771 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data771 {
  given Ordering[Data771] = Ordering.by(_.id)
  def empty: Data771 = Data771(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data771 =
    Data771(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data771] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
