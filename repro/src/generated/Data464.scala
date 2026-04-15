package generated

final case class Data464(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data464 = copy(name = name.toUpperCase)
  def scale(k: Double): Data464 = copy(value = value * k)
  def addTag(t: String): Data464 = copy(tags = t :: tags)
  def put(k: String, v: String): Data464 = copy(meta = meta.updated(k, v))
  def merge(other: Data464): Data464 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data464 {
  given Ordering[Data464] = Ordering.by(_.id)
  def empty: Data464 = Data464(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data464 =
    Data464(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data464] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
