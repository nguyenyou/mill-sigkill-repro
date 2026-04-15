package generated

final case class Data17(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data17 = copy(name = name.toUpperCase)
  def scale(k: Double): Data17 = copy(value = value * k)
  def addTag(t: String): Data17 = copy(tags = t :: tags)
  def put(k: String, v: String): Data17 = copy(meta = meta.updated(k, v))
  def merge(other: Data17): Data17 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data17 {
  given Ordering[Data17] = Ordering.by(_.id)
  def empty: Data17 = Data17(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data17 =
    Data17(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data17] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
