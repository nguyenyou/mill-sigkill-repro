package generated

final case class Data442(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data442 = copy(name = name.toUpperCase)
  def scale(k: Double): Data442 = copy(value = value * k)
  def addTag(t: String): Data442 = copy(tags = t :: tags)
  def put(k: String, v: String): Data442 = copy(meta = meta.updated(k, v))
  def merge(other: Data442): Data442 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data442 {
  given Ordering[Data442] = Ordering.by(_.id)
  def empty: Data442 = Data442(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data442 =
    Data442(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data442] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
