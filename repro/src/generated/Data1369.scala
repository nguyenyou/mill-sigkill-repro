package generated

final case class Data1369(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1369 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1369 = copy(value = value * k)
  def addTag(t: String): Data1369 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1369 = copy(meta = meta.updated(k, v))
  def merge(other: Data1369): Data1369 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1369 {
  given Ordering[Data1369] = Ordering.by(_.id)
  def empty: Data1369 = Data1369(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1369 =
    Data1369(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1369] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
