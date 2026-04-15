package generated

final case class Data440(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data440 = copy(name = name.toUpperCase)
  def scale(k: Double): Data440 = copy(value = value * k)
  def addTag(t: String): Data440 = copy(tags = t :: tags)
  def put(k: String, v: String): Data440 = copy(meta = meta.updated(k, v))
  def merge(other: Data440): Data440 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data440 {
  given Ordering[Data440] = Ordering.by(_.id)
  def empty: Data440 = Data440(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data440 =
    Data440(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data440] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
