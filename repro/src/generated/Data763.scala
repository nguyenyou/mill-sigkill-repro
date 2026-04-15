package generated

final case class Data763(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data763 = copy(name = name.toUpperCase)
  def scale(k: Double): Data763 = copy(value = value * k)
  def addTag(t: String): Data763 = copy(tags = t :: tags)
  def put(k: String, v: String): Data763 = copy(meta = meta.updated(k, v))
  def merge(other: Data763): Data763 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data763 {
  given Ordering[Data763] = Ordering.by(_.id)
  def empty: Data763 = Data763(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data763 =
    Data763(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data763] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
