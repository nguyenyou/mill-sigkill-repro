package generated

final case class Data778(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data778 = copy(name = name.toUpperCase)
  def scale(k: Double): Data778 = copy(value = value * k)
  def addTag(t: String): Data778 = copy(tags = t :: tags)
  def put(k: String, v: String): Data778 = copy(meta = meta.updated(k, v))
  def merge(other: Data778): Data778 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data778 {
  given Ordering[Data778] = Ordering.by(_.id)
  def empty: Data778 = Data778(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data778 =
    Data778(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data778] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
