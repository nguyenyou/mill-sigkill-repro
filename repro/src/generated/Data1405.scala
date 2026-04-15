package generated

final case class Data1405(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1405 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1405 = copy(value = value * k)
  def addTag(t: String): Data1405 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1405 = copy(meta = meta.updated(k, v))
  def merge(other: Data1405): Data1405 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1405 {
  given Ordering[Data1405] = Ordering.by(_.id)
  def empty: Data1405 = Data1405(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1405 =
    Data1405(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1405] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
