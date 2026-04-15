package generated

final case class Data581(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data581 = copy(name = name.toUpperCase)
  def scale(k: Double): Data581 = copy(value = value * k)
  def addTag(t: String): Data581 = copy(tags = t :: tags)
  def put(k: String, v: String): Data581 = copy(meta = meta.updated(k, v))
  def merge(other: Data581): Data581 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data581 {
  given Ordering[Data581] = Ordering.by(_.id)
  def empty: Data581 = Data581(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data581 =
    Data581(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data581] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
