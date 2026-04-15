package generated

final case class Data263(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data263 = copy(name = name.toUpperCase)
  def scale(k: Double): Data263 = copy(value = value * k)
  def addTag(t: String): Data263 = copy(tags = t :: tags)
  def put(k: String, v: String): Data263 = copy(meta = meta.updated(k, v))
  def merge(other: Data263): Data263 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data263 {
  given Ordering[Data263] = Ordering.by(_.id)
  def empty: Data263 = Data263(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data263 =
    Data263(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data263] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
