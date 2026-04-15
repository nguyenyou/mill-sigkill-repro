package generated

final case class Data1011(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1011 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1011 = copy(value = value * k)
  def addTag(t: String): Data1011 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1011 = copy(meta = meta.updated(k, v))
  def merge(other: Data1011): Data1011 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1011 {
  given Ordering[Data1011] = Ordering.by(_.id)
  def empty: Data1011 = Data1011(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1011 =
    Data1011(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1011] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
