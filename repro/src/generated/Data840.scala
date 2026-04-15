package generated

final case class Data840(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data840 = copy(name = name.toUpperCase)
  def scale(k: Double): Data840 = copy(value = value * k)
  def addTag(t: String): Data840 = copy(tags = t :: tags)
  def put(k: String, v: String): Data840 = copy(meta = meta.updated(k, v))
  def merge(other: Data840): Data840 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data840 {
  given Ordering[Data840] = Ordering.by(_.id)
  def empty: Data840 = Data840(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data840 =
    Data840(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data840] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
