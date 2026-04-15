package generated

final case class Data1354(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1354 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1354 = copy(value = value * k)
  def addTag(t: String): Data1354 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1354 = copy(meta = meta.updated(k, v))
  def merge(other: Data1354): Data1354 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1354 {
  given Ordering[Data1354] = Ordering.by(_.id)
  def empty: Data1354 = Data1354(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1354 =
    Data1354(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1354] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
