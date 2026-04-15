package generated

final case class Data1198(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1198 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1198 = copy(value = value * k)
  def addTag(t: String): Data1198 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1198 = copy(meta = meta.updated(k, v))
  def merge(other: Data1198): Data1198 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1198 {
  given Ordering[Data1198] = Ordering.by(_.id)
  def empty: Data1198 = Data1198(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1198 =
    Data1198(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1198] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
