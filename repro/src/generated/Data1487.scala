package generated

final case class Data1487(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1487 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1487 = copy(value = value * k)
  def addTag(t: String): Data1487 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1487 = copy(meta = meta.updated(k, v))
  def merge(other: Data1487): Data1487 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1487 {
  given Ordering[Data1487] = Ordering.by(_.id)
  def empty: Data1487 = Data1487(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1487 =
    Data1487(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1487] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
