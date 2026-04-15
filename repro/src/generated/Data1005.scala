package generated

final case class Data1005(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1005 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1005 = copy(value = value * k)
  def addTag(t: String): Data1005 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1005 = copy(meta = meta.updated(k, v))
  def merge(other: Data1005): Data1005 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1005 {
  given Ordering[Data1005] = Ordering.by(_.id)
  def empty: Data1005 = Data1005(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1005 =
    Data1005(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1005] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
