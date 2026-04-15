package generated

final case class Data903(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data903 = copy(name = name.toUpperCase)
  def scale(k: Double): Data903 = copy(value = value * k)
  def addTag(t: String): Data903 = copy(tags = t :: tags)
  def put(k: String, v: String): Data903 = copy(meta = meta.updated(k, v))
  def merge(other: Data903): Data903 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data903 {
  given Ordering[Data903] = Ordering.by(_.id)
  def empty: Data903 = Data903(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data903 =
    Data903(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data903] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
