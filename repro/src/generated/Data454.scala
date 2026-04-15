package generated

final case class Data454(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data454 = copy(name = name.toUpperCase)
  def scale(k: Double): Data454 = copy(value = value * k)
  def addTag(t: String): Data454 = copy(tags = t :: tags)
  def put(k: String, v: String): Data454 = copy(meta = meta.updated(k, v))
  def merge(other: Data454): Data454 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data454 {
  given Ordering[Data454] = Ordering.by(_.id)
  def empty: Data454 = Data454(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data454 =
    Data454(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data454] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
