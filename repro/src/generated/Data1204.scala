package generated

final case class Data1204(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1204 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1204 = copy(value = value * k)
  def addTag(t: String): Data1204 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1204 = copy(meta = meta.updated(k, v))
  def merge(other: Data1204): Data1204 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1204 {
  given Ordering[Data1204] = Ordering.by(_.id)
  def empty: Data1204 = Data1204(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1204 =
    Data1204(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1204] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
