package generated

final case class Data588(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data588 = copy(name = name.toUpperCase)
  def scale(k: Double): Data588 = copy(value = value * k)
  def addTag(t: String): Data588 = copy(tags = t :: tags)
  def put(k: String, v: String): Data588 = copy(meta = meta.updated(k, v))
  def merge(other: Data588): Data588 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data588 {
  given Ordering[Data588] = Ordering.by(_.id)
  def empty: Data588 = Data588(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data588 =
    Data588(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data588] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
