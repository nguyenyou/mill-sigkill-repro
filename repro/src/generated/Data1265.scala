package generated

final case class Data1265(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1265 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1265 = copy(value = value * k)
  def addTag(t: String): Data1265 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1265 = copy(meta = meta.updated(k, v))
  def merge(other: Data1265): Data1265 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1265 {
  given Ordering[Data1265] = Ordering.by(_.id)
  def empty: Data1265 = Data1265(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1265 =
    Data1265(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1265] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
