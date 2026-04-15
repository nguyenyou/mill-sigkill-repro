package generated

final case class Data1189(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1189 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1189 = copy(value = value * k)
  def addTag(t: String): Data1189 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1189 = copy(meta = meta.updated(k, v))
  def merge(other: Data1189): Data1189 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1189 {
  given Ordering[Data1189] = Ordering.by(_.id)
  def empty: Data1189 = Data1189(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1189 =
    Data1189(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1189] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
