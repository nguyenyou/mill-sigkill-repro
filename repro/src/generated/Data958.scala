package generated

final case class Data958(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data958 = copy(name = name.toUpperCase)
  def scale(k: Double): Data958 = copy(value = value * k)
  def addTag(t: String): Data958 = copy(tags = t :: tags)
  def put(k: String, v: String): Data958 = copy(meta = meta.updated(k, v))
  def merge(other: Data958): Data958 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data958 {
  given Ordering[Data958] = Ordering.by(_.id)
  def empty: Data958 = Data958(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data958 =
    Data958(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data958] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
