package generated

final case class Data656(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data656 = copy(name = name.toUpperCase)
  def scale(k: Double): Data656 = copy(value = value * k)
  def addTag(t: String): Data656 = copy(tags = t :: tags)
  def put(k: String, v: String): Data656 = copy(meta = meta.updated(k, v))
  def merge(other: Data656): Data656 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data656 {
  given Ordering[Data656] = Ordering.by(_.id)
  def empty: Data656 = Data656(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data656 =
    Data656(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data656] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
