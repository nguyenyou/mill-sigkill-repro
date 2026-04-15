package generated

final case class Data1481(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1481 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1481 = copy(value = value * k)
  def addTag(t: String): Data1481 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1481 = copy(meta = meta.updated(k, v))
  def merge(other: Data1481): Data1481 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1481 {
  given Ordering[Data1481] = Ordering.by(_.id)
  def empty: Data1481 = Data1481(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1481 =
    Data1481(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1481] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
