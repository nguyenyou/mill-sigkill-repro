package generated

final case class Data1141(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1141 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1141 = copy(value = value * k)
  def addTag(t: String): Data1141 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1141 = copy(meta = meta.updated(k, v))
  def merge(other: Data1141): Data1141 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1141 {
  given Ordering[Data1141] = Ordering.by(_.id)
  def empty: Data1141 = Data1141(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1141 =
    Data1141(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1141] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
