package generated

final case class Data1109(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1109 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1109 = copy(value = value * k)
  def addTag(t: String): Data1109 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1109 = copy(meta = meta.updated(k, v))
  def merge(other: Data1109): Data1109 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1109 {
  given Ordering[Data1109] = Ordering.by(_.id)
  def empty: Data1109 = Data1109(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1109 =
    Data1109(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1109] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
