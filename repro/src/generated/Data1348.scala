package generated

final case class Data1348(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1348 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1348 = copy(value = value * k)
  def addTag(t: String): Data1348 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1348 = copy(meta = meta.updated(k, v))
  def merge(other: Data1348): Data1348 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1348 {
  given Ordering[Data1348] = Ordering.by(_.id)
  def empty: Data1348 = Data1348(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1348 =
    Data1348(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1348] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
