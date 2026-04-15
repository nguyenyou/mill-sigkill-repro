package generated

final case class Data1149(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1149 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1149 = copy(value = value * k)
  def addTag(t: String): Data1149 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1149 = copy(meta = meta.updated(k, v))
  def merge(other: Data1149): Data1149 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1149 {
  given Ordering[Data1149] = Ordering.by(_.id)
  def empty: Data1149 = Data1149(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1149 =
    Data1149(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1149] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
