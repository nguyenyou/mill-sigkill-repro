package generated

final case class Data1185(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1185 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1185 = copy(value = value * k)
  def addTag(t: String): Data1185 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1185 = copy(meta = meta.updated(k, v))
  def merge(other: Data1185): Data1185 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1185 {
  given Ordering[Data1185] = Ordering.by(_.id)
  def empty: Data1185 = Data1185(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1185 =
    Data1185(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1185] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
