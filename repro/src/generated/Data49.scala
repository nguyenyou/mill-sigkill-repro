package generated

final case class Data49(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data49 = copy(name = name.toUpperCase)
  def scale(k: Double): Data49 = copy(value = value * k)
  def addTag(t: String): Data49 = copy(tags = t :: tags)
  def put(k: String, v: String): Data49 = copy(meta = meta.updated(k, v))
  def merge(other: Data49): Data49 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data49 {
  given Ordering[Data49] = Ordering.by(_.id)
  def empty: Data49 = Data49(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data49 =
    Data49(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data49] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
