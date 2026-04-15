package generated

final case class Data411(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data411 = copy(name = name.toUpperCase)
  def scale(k: Double): Data411 = copy(value = value * k)
  def addTag(t: String): Data411 = copy(tags = t :: tags)
  def put(k: String, v: String): Data411 = copy(meta = meta.updated(k, v))
  def merge(other: Data411): Data411 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data411 {
  given Ordering[Data411] = Ordering.by(_.id)
  def empty: Data411 = Data411(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data411 =
    Data411(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data411] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
