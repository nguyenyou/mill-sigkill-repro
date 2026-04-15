package generated

final case class Data444(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data444 = copy(name = name.toUpperCase)
  def scale(k: Double): Data444 = copy(value = value * k)
  def addTag(t: String): Data444 = copy(tags = t :: tags)
  def put(k: String, v: String): Data444 = copy(meta = meta.updated(k, v))
  def merge(other: Data444): Data444 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data444 {
  given Ordering[Data444] = Ordering.by(_.id)
  def empty: Data444 = Data444(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data444 =
    Data444(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data444] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
