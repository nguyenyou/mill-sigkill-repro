package generated

final case class Data1453(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1453 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1453 = copy(value = value * k)
  def addTag(t: String): Data1453 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1453 = copy(meta = meta.updated(k, v))
  def merge(other: Data1453): Data1453 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1453 {
  given Ordering[Data1453] = Ordering.by(_.id)
  def empty: Data1453 = Data1453(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1453 =
    Data1453(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1453] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
