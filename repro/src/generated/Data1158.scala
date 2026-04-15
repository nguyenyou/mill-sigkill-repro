package generated

final case class Data1158(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1158 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1158 = copy(value = value * k)
  def addTag(t: String): Data1158 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1158 = copy(meta = meta.updated(k, v))
  def merge(other: Data1158): Data1158 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1158 {
  given Ordering[Data1158] = Ordering.by(_.id)
  def empty: Data1158 = Data1158(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1158 =
    Data1158(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1158] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
