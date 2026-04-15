package generated

final case class Data1383(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1383 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1383 = copy(value = value * k)
  def addTag(t: String): Data1383 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1383 = copy(meta = meta.updated(k, v))
  def merge(other: Data1383): Data1383 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1383 {
  given Ordering[Data1383] = Ordering.by(_.id)
  def empty: Data1383 = Data1383(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1383 =
    Data1383(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1383] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
