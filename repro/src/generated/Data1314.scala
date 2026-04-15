package generated

final case class Data1314(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1314 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1314 = copy(value = value * k)
  def addTag(t: String): Data1314 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1314 = copy(meta = meta.updated(k, v))
  def merge(other: Data1314): Data1314 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1314 {
  given Ordering[Data1314] = Ordering.by(_.id)
  def empty: Data1314 = Data1314(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1314 =
    Data1314(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1314] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
