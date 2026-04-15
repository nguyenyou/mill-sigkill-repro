package generated

final case class Data281(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data281 = copy(name = name.toUpperCase)
  def scale(k: Double): Data281 = copy(value = value * k)
  def addTag(t: String): Data281 = copy(tags = t :: tags)
  def put(k: String, v: String): Data281 = copy(meta = meta.updated(k, v))
  def merge(other: Data281): Data281 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data281 {
  given Ordering[Data281] = Ordering.by(_.id)
  def empty: Data281 = Data281(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data281 =
    Data281(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data281] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
