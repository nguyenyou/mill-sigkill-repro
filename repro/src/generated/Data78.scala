package generated

final case class Data78(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data78 = copy(name = name.toUpperCase)
  def scale(k: Double): Data78 = copy(value = value * k)
  def addTag(t: String): Data78 = copy(tags = t :: tags)
  def put(k: String, v: String): Data78 = copy(meta = meta.updated(k, v))
  def merge(other: Data78): Data78 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data78 {
  given Ordering[Data78] = Ordering.by(_.id)
  def empty: Data78 = Data78(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data78 =
    Data78(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data78] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
