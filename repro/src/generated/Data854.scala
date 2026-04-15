package generated

final case class Data854(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data854 = copy(name = name.toUpperCase)
  def scale(k: Double): Data854 = copy(value = value * k)
  def addTag(t: String): Data854 = copy(tags = t :: tags)
  def put(k: String, v: String): Data854 = copy(meta = meta.updated(k, v))
  def merge(other: Data854): Data854 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data854 {
  given Ordering[Data854] = Ordering.by(_.id)
  def empty: Data854 = Data854(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data854 =
    Data854(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data854] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
