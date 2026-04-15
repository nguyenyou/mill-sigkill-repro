package generated

final case class Data729(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data729 = copy(name = name.toUpperCase)
  def scale(k: Double): Data729 = copy(value = value * k)
  def addTag(t: String): Data729 = copy(tags = t :: tags)
  def put(k: String, v: String): Data729 = copy(meta = meta.updated(k, v))
  def merge(other: Data729): Data729 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data729 {
  given Ordering[Data729] = Ordering.by(_.id)
  def empty: Data729 = Data729(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data729 =
    Data729(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data729] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
