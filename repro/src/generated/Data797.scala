package generated

final case class Data797(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data797 = copy(name = name.toUpperCase)
  def scale(k: Double): Data797 = copy(value = value * k)
  def addTag(t: String): Data797 = copy(tags = t :: tags)
  def put(k: String, v: String): Data797 = copy(meta = meta.updated(k, v))
  def merge(other: Data797): Data797 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data797 {
  given Ordering[Data797] = Ordering.by(_.id)
  def empty: Data797 = Data797(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data797 =
    Data797(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data797] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
