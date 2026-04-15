package generated

final case class Data1147(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1147 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1147 = copy(value = value * k)
  def addTag(t: String): Data1147 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1147 = copy(meta = meta.updated(k, v))
  def merge(other: Data1147): Data1147 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1147 {
  given Ordering[Data1147] = Ordering.by(_.id)
  def empty: Data1147 = Data1147(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1147 =
    Data1147(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1147] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
