package generated

final case class Data88(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data88 = copy(name = name.toUpperCase)
  def scale(k: Double): Data88 = copy(value = value * k)
  def addTag(t: String): Data88 = copy(tags = t :: tags)
  def put(k: String, v: String): Data88 = copy(meta = meta.updated(k, v))
  def merge(other: Data88): Data88 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data88 {
  given Ordering[Data88] = Ordering.by(_.id)
  def empty: Data88 = Data88(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data88 =
    Data88(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data88] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
