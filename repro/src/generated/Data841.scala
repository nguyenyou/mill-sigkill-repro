package generated

final case class Data841(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data841 = copy(name = name.toUpperCase)
  def scale(k: Double): Data841 = copy(value = value * k)
  def addTag(t: String): Data841 = copy(tags = t :: tags)
  def put(k: String, v: String): Data841 = copy(meta = meta.updated(k, v))
  def merge(other: Data841): Data841 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data841 {
  given Ordering[Data841] = Ordering.by(_.id)
  def empty: Data841 = Data841(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data841 =
    Data841(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data841] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
