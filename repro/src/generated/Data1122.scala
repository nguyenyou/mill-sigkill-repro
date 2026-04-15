package generated

final case class Data1122(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1122 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1122 = copy(value = value * k)
  def addTag(t: String): Data1122 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1122 = copy(meta = meta.updated(k, v))
  def merge(other: Data1122): Data1122 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1122 {
  given Ordering[Data1122] = Ordering.by(_.id)
  def empty: Data1122 = Data1122(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1122 =
    Data1122(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1122] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
