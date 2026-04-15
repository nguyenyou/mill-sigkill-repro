package generated

final case class Data658(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data658 = copy(name = name.toUpperCase)
  def scale(k: Double): Data658 = copy(value = value * k)
  def addTag(t: String): Data658 = copy(tags = t :: tags)
  def put(k: String, v: String): Data658 = copy(meta = meta.updated(k, v))
  def merge(other: Data658): Data658 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data658 {
  given Ordering[Data658] = Ordering.by(_.id)
  def empty: Data658 = Data658(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data658 =
    Data658(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data658] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
