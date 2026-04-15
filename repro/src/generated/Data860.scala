package generated

final case class Data860(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data860 = copy(name = name.toUpperCase)
  def scale(k: Double): Data860 = copy(value = value * k)
  def addTag(t: String): Data860 = copy(tags = t :: tags)
  def put(k: String, v: String): Data860 = copy(meta = meta.updated(k, v))
  def merge(other: Data860): Data860 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data860 {
  given Ordering[Data860] = Ordering.by(_.id)
  def empty: Data860 = Data860(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data860 =
    Data860(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data860] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
