package generated

final case class Data1134(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1134 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1134 = copy(value = value * k)
  def addTag(t: String): Data1134 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1134 = copy(meta = meta.updated(k, v))
  def merge(other: Data1134): Data1134 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1134 {
  given Ordering[Data1134] = Ordering.by(_.id)
  def empty: Data1134 = Data1134(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1134 =
    Data1134(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1134] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
