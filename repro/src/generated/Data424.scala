package generated

final case class Data424(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data424 = copy(name = name.toUpperCase)
  def scale(k: Double): Data424 = copy(value = value * k)
  def addTag(t: String): Data424 = copy(tags = t :: tags)
  def put(k: String, v: String): Data424 = copy(meta = meta.updated(k, v))
  def merge(other: Data424): Data424 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data424 {
  given Ordering[Data424] = Ordering.by(_.id)
  def empty: Data424 = Data424(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data424 =
    Data424(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data424] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
