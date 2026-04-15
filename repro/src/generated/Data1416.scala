package generated

final case class Data1416(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1416 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1416 = copy(value = value * k)
  def addTag(t: String): Data1416 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1416 = copy(meta = meta.updated(k, v))
  def merge(other: Data1416): Data1416 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1416 {
  given Ordering[Data1416] = Ordering.by(_.id)
  def empty: Data1416 = Data1416(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1416 =
    Data1416(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1416] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
