package generated

final case class Data363(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data363 = copy(name = name.toUpperCase)
  def scale(k: Double): Data363 = copy(value = value * k)
  def addTag(t: String): Data363 = copy(tags = t :: tags)
  def put(k: String, v: String): Data363 = copy(meta = meta.updated(k, v))
  def merge(other: Data363): Data363 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data363 {
  given Ordering[Data363] = Ordering.by(_.id)
  def empty: Data363 = Data363(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data363 =
    Data363(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data363] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
