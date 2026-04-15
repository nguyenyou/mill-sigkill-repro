package generated

final case class Data645(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data645 = copy(name = name.toUpperCase)
  def scale(k: Double): Data645 = copy(value = value * k)
  def addTag(t: String): Data645 = copy(tags = t :: tags)
  def put(k: String, v: String): Data645 = copy(meta = meta.updated(k, v))
  def merge(other: Data645): Data645 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data645 {
  given Ordering[Data645] = Ordering.by(_.id)
  def empty: Data645 = Data645(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data645 =
    Data645(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data645] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
