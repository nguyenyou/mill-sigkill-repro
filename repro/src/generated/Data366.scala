package generated

final case class Data366(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data366 = copy(name = name.toUpperCase)
  def scale(k: Double): Data366 = copy(value = value * k)
  def addTag(t: String): Data366 = copy(tags = t :: tags)
  def put(k: String, v: String): Data366 = copy(meta = meta.updated(k, v))
  def merge(other: Data366): Data366 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data366 {
  given Ordering[Data366] = Ordering.by(_.id)
  def empty: Data366 = Data366(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data366 =
    Data366(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data366] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
