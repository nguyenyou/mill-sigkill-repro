package generated

final case class Data1167(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1167 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1167 = copy(value = value * k)
  def addTag(t: String): Data1167 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1167 = copy(meta = meta.updated(k, v))
  def merge(other: Data1167): Data1167 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1167 {
  given Ordering[Data1167] = Ordering.by(_.id)
  def empty: Data1167 = Data1167(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1167 =
    Data1167(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1167] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
