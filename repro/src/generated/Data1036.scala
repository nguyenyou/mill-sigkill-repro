package generated

final case class Data1036(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1036 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1036 = copy(value = value * k)
  def addTag(t: String): Data1036 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1036 = copy(meta = meta.updated(k, v))
  def merge(other: Data1036): Data1036 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1036 {
  given Ordering[Data1036] = Ordering.by(_.id)
  def empty: Data1036 = Data1036(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1036 =
    Data1036(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1036] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
