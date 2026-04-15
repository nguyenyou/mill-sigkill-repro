package generated

final case class Data482(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data482 = copy(name = name.toUpperCase)
  def scale(k: Double): Data482 = copy(value = value * k)
  def addTag(t: String): Data482 = copy(tags = t :: tags)
  def put(k: String, v: String): Data482 = copy(meta = meta.updated(k, v))
  def merge(other: Data482): Data482 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data482 {
  given Ordering[Data482] = Ordering.by(_.id)
  def empty: Data482 = Data482(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data482 =
    Data482(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data482] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
