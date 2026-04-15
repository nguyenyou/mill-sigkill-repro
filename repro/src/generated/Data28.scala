package generated

final case class Data28(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data28 = copy(name = name.toUpperCase)
  def scale(k: Double): Data28 = copy(value = value * k)
  def addTag(t: String): Data28 = copy(tags = t :: tags)
  def put(k: String, v: String): Data28 = copy(meta = meta.updated(k, v))
  def merge(other: Data28): Data28 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data28 {
  given Ordering[Data28] = Ordering.by(_.id)
  def empty: Data28 = Data28(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data28 =
    Data28(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data28] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
