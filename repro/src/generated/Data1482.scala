package generated

final case class Data1482(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1482 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1482 = copy(value = value * k)
  def addTag(t: String): Data1482 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1482 = copy(meta = meta.updated(k, v))
  def merge(other: Data1482): Data1482 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1482 {
  given Ordering[Data1482] = Ordering.by(_.id)
  def empty: Data1482 = Data1482(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1482 =
    Data1482(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1482] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
