package generated

final case class Data1033(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1033 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1033 = copy(value = value * k)
  def addTag(t: String): Data1033 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1033 = copy(meta = meta.updated(k, v))
  def merge(other: Data1033): Data1033 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1033 {
  given Ordering[Data1033] = Ordering.by(_.id)
  def empty: Data1033 = Data1033(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1033 =
    Data1033(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1033] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
