package generated

final case class Data530(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data530 = copy(name = name.toUpperCase)
  def scale(k: Double): Data530 = copy(value = value * k)
  def addTag(t: String): Data530 = copy(tags = t :: tags)
  def put(k: String, v: String): Data530 = copy(meta = meta.updated(k, v))
  def merge(other: Data530): Data530 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data530 {
  given Ordering[Data530] = Ordering.by(_.id)
  def empty: Data530 = Data530(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data530 =
    Data530(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data530] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
