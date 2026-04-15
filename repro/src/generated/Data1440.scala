package generated

final case class Data1440(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1440 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1440 = copy(value = value * k)
  def addTag(t: String): Data1440 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1440 = copy(meta = meta.updated(k, v))
  def merge(other: Data1440): Data1440 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1440 {
  given Ordering[Data1440] = Ordering.by(_.id)
  def empty: Data1440 = Data1440(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1440 =
    Data1440(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1440] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
