package generated

final case class Data756(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data756 = copy(name = name.toUpperCase)
  def scale(k: Double): Data756 = copy(value = value * k)
  def addTag(t: String): Data756 = copy(tags = t :: tags)
  def put(k: String, v: String): Data756 = copy(meta = meta.updated(k, v))
  def merge(other: Data756): Data756 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data756 {
  given Ordering[Data756] = Ordering.by(_.id)
  def empty: Data756 = Data756(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data756 =
    Data756(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data756] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
