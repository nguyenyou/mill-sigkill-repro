package generated

final case class Data868(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data868 = copy(name = name.toUpperCase)
  def scale(k: Double): Data868 = copy(value = value * k)
  def addTag(t: String): Data868 = copy(tags = t :: tags)
  def put(k: String, v: String): Data868 = copy(meta = meta.updated(k, v))
  def merge(other: Data868): Data868 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data868 {
  given Ordering[Data868] = Ordering.by(_.id)
  def empty: Data868 = Data868(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data868 =
    Data868(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data868] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
