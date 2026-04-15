package generated

final case class Data112(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data112 = copy(name = name.toUpperCase)
  def scale(k: Double): Data112 = copy(value = value * k)
  def addTag(t: String): Data112 = copy(tags = t :: tags)
  def put(k: String, v: String): Data112 = copy(meta = meta.updated(k, v))
  def merge(other: Data112): Data112 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data112 {
  given Ordering[Data112] = Ordering.by(_.id)
  def empty: Data112 = Data112(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data112 =
    Data112(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data112] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
