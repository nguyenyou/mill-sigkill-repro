package generated

final case class Data960(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data960 = copy(name = name.toUpperCase)
  def scale(k: Double): Data960 = copy(value = value * k)
  def addTag(t: String): Data960 = copy(tags = t :: tags)
  def put(k: String, v: String): Data960 = copy(meta = meta.updated(k, v))
  def merge(other: Data960): Data960 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data960 {
  given Ordering[Data960] = Ordering.by(_.id)
  def empty: Data960 = Data960(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data960 =
    Data960(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data960] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
