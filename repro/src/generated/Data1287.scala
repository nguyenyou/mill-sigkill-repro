package generated

final case class Data1287(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1287 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1287 = copy(value = value * k)
  def addTag(t: String): Data1287 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1287 = copy(meta = meta.updated(k, v))
  def merge(other: Data1287): Data1287 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1287 {
  given Ordering[Data1287] = Ordering.by(_.id)
  def empty: Data1287 = Data1287(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1287 =
    Data1287(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1287] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
