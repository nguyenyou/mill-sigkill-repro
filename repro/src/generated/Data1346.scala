package generated

final case class Data1346(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1346 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1346 = copy(value = value * k)
  def addTag(t: String): Data1346 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1346 = copy(meta = meta.updated(k, v))
  def merge(other: Data1346): Data1346 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1346 {
  given Ordering[Data1346] = Ordering.by(_.id)
  def empty: Data1346 = Data1346(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1346 =
    Data1346(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1346] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
