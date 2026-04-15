package generated

final case class Data622(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data622 = copy(name = name.toUpperCase)
  def scale(k: Double): Data622 = copy(value = value * k)
  def addTag(t: String): Data622 = copy(tags = t :: tags)
  def put(k: String, v: String): Data622 = copy(meta = meta.updated(k, v))
  def merge(other: Data622): Data622 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data622 {
  given Ordering[Data622] = Ordering.by(_.id)
  def empty: Data622 = Data622(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data622 =
    Data622(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data622] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
