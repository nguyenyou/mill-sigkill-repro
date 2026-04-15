package generated

final case class Data827(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data827 = copy(name = name.toUpperCase)
  def scale(k: Double): Data827 = copy(value = value * k)
  def addTag(t: String): Data827 = copy(tags = t :: tags)
  def put(k: String, v: String): Data827 = copy(meta = meta.updated(k, v))
  def merge(other: Data827): Data827 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data827 {
  given Ordering[Data827] = Ordering.by(_.id)
  def empty: Data827 = Data827(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data827 =
    Data827(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data827] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
