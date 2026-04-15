package generated

final case class Data1233(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1233 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1233 = copy(value = value * k)
  def addTag(t: String): Data1233 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1233 = copy(meta = meta.updated(k, v))
  def merge(other: Data1233): Data1233 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1233 {
  given Ordering[Data1233] = Ordering.by(_.id)
  def empty: Data1233 = Data1233(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1233 =
    Data1233(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1233] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
