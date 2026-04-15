package generated

final case class Data1352(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1352 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1352 = copy(value = value * k)
  def addTag(t: String): Data1352 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1352 = copy(meta = meta.updated(k, v))
  def merge(other: Data1352): Data1352 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1352 {
  given Ordering[Data1352] = Ordering.by(_.id)
  def empty: Data1352 = Data1352(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1352 =
    Data1352(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1352] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
