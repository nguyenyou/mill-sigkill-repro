package generated

final case class Data1325(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1325 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1325 = copy(value = value * k)
  def addTag(t: String): Data1325 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1325 = copy(meta = meta.updated(k, v))
  def merge(other: Data1325): Data1325 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1325 {
  given Ordering[Data1325] = Ordering.by(_.id)
  def empty: Data1325 = Data1325(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1325 =
    Data1325(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1325] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
