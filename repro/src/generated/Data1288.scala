package generated

final case class Data1288(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1288 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1288 = copy(value = value * k)
  def addTag(t: String): Data1288 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1288 = copy(meta = meta.updated(k, v))
  def merge(other: Data1288): Data1288 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1288 {
  given Ordering[Data1288] = Ordering.by(_.id)
  def empty: Data1288 = Data1288(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1288 =
    Data1288(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1288] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
