package generated

final case class Data1488(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1488 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1488 = copy(value = value * k)
  def addTag(t: String): Data1488 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1488 = copy(meta = meta.updated(k, v))
  def merge(other: Data1488): Data1488 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1488 {
  given Ordering[Data1488] = Ordering.by(_.id)
  def empty: Data1488 = Data1488(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1488 =
    Data1488(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1488] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
