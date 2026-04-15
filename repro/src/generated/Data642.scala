package generated

final case class Data642(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data642 = copy(name = name.toUpperCase)
  def scale(k: Double): Data642 = copy(value = value * k)
  def addTag(t: String): Data642 = copy(tags = t :: tags)
  def put(k: String, v: String): Data642 = copy(meta = meta.updated(k, v))
  def merge(other: Data642): Data642 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data642 {
  given Ordering[Data642] = Ordering.by(_.id)
  def empty: Data642 = Data642(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data642 =
    Data642(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data642] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
