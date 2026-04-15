package generated

final case class Data1299(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1299 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1299 = copy(value = value * k)
  def addTag(t: String): Data1299 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1299 = copy(meta = meta.updated(k, v))
  def merge(other: Data1299): Data1299 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1299 {
  given Ordering[Data1299] = Ordering.by(_.id)
  def empty: Data1299 = Data1299(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1299 =
    Data1299(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1299] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
