package generated

final case class Data486(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data486 = copy(name = name.toUpperCase)
  def scale(k: Double): Data486 = copy(value = value * k)
  def addTag(t: String): Data486 = copy(tags = t :: tags)
  def put(k: String, v: String): Data486 = copy(meta = meta.updated(k, v))
  def merge(other: Data486): Data486 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data486 {
  given Ordering[Data486] = Ordering.by(_.id)
  def empty: Data486 = Data486(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data486 =
    Data486(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data486] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
