package generated

final case class Data1105(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1105 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1105 = copy(value = value * k)
  def addTag(t: String): Data1105 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1105 = copy(meta = meta.updated(k, v))
  def merge(other: Data1105): Data1105 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1105 {
  given Ordering[Data1105] = Ordering.by(_.id)
  def empty: Data1105 = Data1105(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1105 =
    Data1105(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1105] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
