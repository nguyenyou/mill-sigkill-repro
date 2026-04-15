package generated

final case class Data1061(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1061 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1061 = copy(value = value * k)
  def addTag(t: String): Data1061 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1061 = copy(meta = meta.updated(k, v))
  def merge(other: Data1061): Data1061 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1061 {
  given Ordering[Data1061] = Ordering.by(_.id)
  def empty: Data1061 = Data1061(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1061 =
    Data1061(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1061] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
