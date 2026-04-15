package generated

final case class Data1351(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1351 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1351 = copy(value = value * k)
  def addTag(t: String): Data1351 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1351 = copy(meta = meta.updated(k, v))
  def merge(other: Data1351): Data1351 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1351 {
  given Ordering[Data1351] = Ordering.by(_.id)
  def empty: Data1351 = Data1351(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1351 =
    Data1351(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1351] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
