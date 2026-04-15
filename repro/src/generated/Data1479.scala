package generated

final case class Data1479(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1479 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1479 = copy(value = value * k)
  def addTag(t: String): Data1479 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1479 = copy(meta = meta.updated(k, v))
  def merge(other: Data1479): Data1479 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1479 {
  given Ordering[Data1479] = Ordering.by(_.id)
  def empty: Data1479 = Data1479(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1479 =
    Data1479(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1479] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
