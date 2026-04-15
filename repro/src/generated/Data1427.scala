package generated

final case class Data1427(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1427 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1427 = copy(value = value * k)
  def addTag(t: String): Data1427 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1427 = copy(meta = meta.updated(k, v))
  def merge(other: Data1427): Data1427 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1427 {
  given Ordering[Data1427] = Ordering.by(_.id)
  def empty: Data1427 = Data1427(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1427 =
    Data1427(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1427] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
