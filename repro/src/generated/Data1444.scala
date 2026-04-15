package generated

final case class Data1444(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1444 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1444 = copy(value = value * k)
  def addTag(t: String): Data1444 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1444 = copy(meta = meta.updated(k, v))
  def merge(other: Data1444): Data1444 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1444 {
  given Ordering[Data1444] = Ordering.by(_.id)
  def empty: Data1444 = Data1444(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1444 =
    Data1444(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1444] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
