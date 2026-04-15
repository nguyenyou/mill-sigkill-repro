package generated

final case class Data649(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data649 = copy(name = name.toUpperCase)
  def scale(k: Double): Data649 = copy(value = value * k)
  def addTag(t: String): Data649 = copy(tags = t :: tags)
  def put(k: String, v: String): Data649 = copy(meta = meta.updated(k, v))
  def merge(other: Data649): Data649 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data649 {
  given Ordering[Data649] = Ordering.by(_.id)
  def empty: Data649 = Data649(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data649 =
    Data649(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data649] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
