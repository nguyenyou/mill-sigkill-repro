package generated

final case class Data1231(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1231 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1231 = copy(value = value * k)
  def addTag(t: String): Data1231 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1231 = copy(meta = meta.updated(k, v))
  def merge(other: Data1231): Data1231 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1231 {
  given Ordering[Data1231] = Ordering.by(_.id)
  def empty: Data1231 = Data1231(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1231 =
    Data1231(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1231] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
