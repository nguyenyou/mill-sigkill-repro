package generated

final case class Data280(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data280 = copy(name = name.toUpperCase)
  def scale(k: Double): Data280 = copy(value = value * k)
  def addTag(t: String): Data280 = copy(tags = t :: tags)
  def put(k: String, v: String): Data280 = copy(meta = meta.updated(k, v))
  def merge(other: Data280): Data280 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data280 {
  given Ordering[Data280] = Ordering.by(_.id)
  def empty: Data280 = Data280(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data280 =
    Data280(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data280] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
