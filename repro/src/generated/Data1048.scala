package generated

final case class Data1048(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1048 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1048 = copy(value = value * k)
  def addTag(t: String): Data1048 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1048 = copy(meta = meta.updated(k, v))
  def merge(other: Data1048): Data1048 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1048 {
  given Ordering[Data1048] = Ordering.by(_.id)
  def empty: Data1048 = Data1048(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1048 =
    Data1048(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1048] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
