package generated

final case class Data780(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data780 = copy(name = name.toUpperCase)
  def scale(k: Double): Data780 = copy(value = value * k)
  def addTag(t: String): Data780 = copy(tags = t :: tags)
  def put(k: String, v: String): Data780 = copy(meta = meta.updated(k, v))
  def merge(other: Data780): Data780 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data780 {
  given Ordering[Data780] = Ordering.by(_.id)
  def empty: Data780 = Data780(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data780 =
    Data780(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data780] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
