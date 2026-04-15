package generated

final case class Data1249(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1249 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1249 = copy(value = value * k)
  def addTag(t: String): Data1249 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1249 = copy(meta = meta.updated(k, v))
  def merge(other: Data1249): Data1249 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1249 {
  given Ordering[Data1249] = Ordering.by(_.id)
  def empty: Data1249 = Data1249(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1249 =
    Data1249(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1249] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
