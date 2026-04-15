package generated
// marker-test

final case class Data5(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data5 = copy(name = name.toUpperCase)
  def scale(k: Double): Data5 = copy(value = value * k)
  def addTag(t: String): Data5 = copy(tags = t :: tags)
  def put(k: String, v: String): Data5 = copy(meta = meta.updated(k, v))
  def merge(other: Data5): Data5 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data5 {
  given Ordering[Data5] = Ordering.by(_.id)
  def empty: Data5 = Data5(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data5 =
    Data5(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data5] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
