package generated

final case class Data1486(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1486 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1486 = copy(value = value * k)
  def addTag(t: String): Data1486 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1486 = copy(meta = meta.updated(k, v))
  def merge(other: Data1486): Data1486 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1486 {
  given Ordering[Data1486] = Ordering.by(_.id)
  def empty: Data1486 = Data1486(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1486 =
    Data1486(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1486] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
