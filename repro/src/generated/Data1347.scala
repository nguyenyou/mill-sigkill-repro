package generated

final case class Data1347(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1347 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1347 = copy(value = value * k)
  def addTag(t: String): Data1347 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1347 = copy(meta = meta.updated(k, v))
  def merge(other: Data1347): Data1347 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1347 {
  given Ordering[Data1347] = Ordering.by(_.id)
  def empty: Data1347 = Data1347(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1347 =
    Data1347(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1347] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
