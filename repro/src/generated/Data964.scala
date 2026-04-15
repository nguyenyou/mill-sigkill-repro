package generated

final case class Data964(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data964 = copy(name = name.toUpperCase)
  def scale(k: Double): Data964 = copy(value = value * k)
  def addTag(t: String): Data964 = copy(tags = t :: tags)
  def put(k: String, v: String): Data964 = copy(meta = meta.updated(k, v))
  def merge(other: Data964): Data964 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data964 {
  given Ordering[Data964] = Ordering.by(_.id)
  def empty: Data964 = Data964(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data964 =
    Data964(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data964] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
