package generated

final case class Data532(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data532 = copy(name = name.toUpperCase)
  def scale(k: Double): Data532 = copy(value = value * k)
  def addTag(t: String): Data532 = copy(tags = t :: tags)
  def put(k: String, v: String): Data532 = copy(meta = meta.updated(k, v))
  def merge(other: Data532): Data532 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data532 {
  given Ordering[Data532] = Ordering.by(_.id)
  def empty: Data532 = Data532(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data532 =
    Data532(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data532] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
