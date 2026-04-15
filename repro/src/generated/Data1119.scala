package generated

final case class Data1119(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1119 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1119 = copy(value = value * k)
  def addTag(t: String): Data1119 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1119 = copy(meta = meta.updated(k, v))
  def merge(other: Data1119): Data1119 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1119 {
  given Ordering[Data1119] = Ordering.by(_.id)
  def empty: Data1119 = Data1119(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1119 =
    Data1119(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1119] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
