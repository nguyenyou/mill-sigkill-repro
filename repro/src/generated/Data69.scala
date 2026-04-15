package generated

final case class Data69(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data69 = copy(name = name.toUpperCase)
  def scale(k: Double): Data69 = copy(value = value * k)
  def addTag(t: String): Data69 = copy(tags = t :: tags)
  def put(k: String, v: String): Data69 = copy(meta = meta.updated(k, v))
  def merge(other: Data69): Data69 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data69 {
  given Ordering[Data69] = Ordering.by(_.id)
  def empty: Data69 = Data69(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data69 =
    Data69(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data69] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
