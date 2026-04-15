package generated

final case class Data630(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data630 = copy(name = name.toUpperCase)
  def scale(k: Double): Data630 = copy(value = value * k)
  def addTag(t: String): Data630 = copy(tags = t :: tags)
  def put(k: String, v: String): Data630 = copy(meta = meta.updated(k, v))
  def merge(other: Data630): Data630 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data630 {
  given Ordering[Data630] = Ordering.by(_.id)
  def empty: Data630 = Data630(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data630 =
    Data630(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data630] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
