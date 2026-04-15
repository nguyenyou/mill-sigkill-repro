package generated

final case class Data620(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data620 = copy(name = name.toUpperCase)
  def scale(k: Double): Data620 = copy(value = value * k)
  def addTag(t: String): Data620 = copy(tags = t :: tags)
  def put(k: String, v: String): Data620 = copy(meta = meta.updated(k, v))
  def merge(other: Data620): Data620 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data620 {
  given Ordering[Data620] = Ordering.by(_.id)
  def empty: Data620 = Data620(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data620 =
    Data620(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data620] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
