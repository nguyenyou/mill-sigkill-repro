package generated

final case class Data1495(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1495 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1495 = copy(value = value * k)
  def addTag(t: String): Data1495 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1495 = copy(meta = meta.updated(k, v))
  def merge(other: Data1495): Data1495 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1495 {
  given Ordering[Data1495] = Ordering.by(_.id)
  def empty: Data1495 = Data1495(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1495 =
    Data1495(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1495] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
