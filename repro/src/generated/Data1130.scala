package generated

final case class Data1130(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1130 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1130 = copy(value = value * k)
  def addTag(t: String): Data1130 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1130 = copy(meta = meta.updated(k, v))
  def merge(other: Data1130): Data1130 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1130 {
  given Ordering[Data1130] = Ordering.by(_.id)
  def empty: Data1130 = Data1130(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1130 =
    Data1130(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1130] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
