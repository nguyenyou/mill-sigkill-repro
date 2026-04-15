package generated

final case class Data1464(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1464 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1464 = copy(value = value * k)
  def addTag(t: String): Data1464 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1464 = copy(meta = meta.updated(k, v))
  def merge(other: Data1464): Data1464 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1464 {
  given Ordering[Data1464] = Ordering.by(_.id)
  def empty: Data1464 = Data1464(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1464 =
    Data1464(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1464] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
