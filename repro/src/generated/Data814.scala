package generated

final case class Data814(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data814 = copy(name = name.toUpperCase)
  def scale(k: Double): Data814 = copy(value = value * k)
  def addTag(t: String): Data814 = copy(tags = t :: tags)
  def put(k: String, v: String): Data814 = copy(meta = meta.updated(k, v))
  def merge(other: Data814): Data814 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data814 {
  given Ordering[Data814] = Ordering.by(_.id)
  def empty: Data814 = Data814(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data814 =
    Data814(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data814] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
