package generated

final case class Data1266(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1266 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1266 = copy(value = value * k)
  def addTag(t: String): Data1266 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1266 = copy(meta = meta.updated(k, v))
  def merge(other: Data1266): Data1266 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1266 {
  given Ordering[Data1266] = Ordering.by(_.id)
  def empty: Data1266 = Data1266(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1266 =
    Data1266(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1266] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
