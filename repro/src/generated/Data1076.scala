package generated

final case class Data1076(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1076 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1076 = copy(value = value * k)
  def addTag(t: String): Data1076 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1076 = copy(meta = meta.updated(k, v))
  def merge(other: Data1076): Data1076 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1076 {
  given Ordering[Data1076] = Ordering.by(_.id)
  def empty: Data1076 = Data1076(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1076 =
    Data1076(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1076] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
