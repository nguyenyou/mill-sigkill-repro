package generated

final case class Data673(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data673 = copy(name = name.toUpperCase)
  def scale(k: Double): Data673 = copy(value = value * k)
  def addTag(t: String): Data673 = copy(tags = t :: tags)
  def put(k: String, v: String): Data673 = copy(meta = meta.updated(k, v))
  def merge(other: Data673): Data673 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data673 {
  given Ordering[Data673] = Ordering.by(_.id)
  def empty: Data673 = Data673(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data673 =
    Data673(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data673] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
