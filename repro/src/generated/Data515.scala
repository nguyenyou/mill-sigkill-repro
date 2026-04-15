package generated

final case class Data515(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data515 = copy(name = name.toUpperCase)
  def scale(k: Double): Data515 = copy(value = value * k)
  def addTag(t: String): Data515 = copy(tags = t :: tags)
  def put(k: String, v: String): Data515 = copy(meta = meta.updated(k, v))
  def merge(other: Data515): Data515 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data515 {
  given Ordering[Data515] = Ordering.by(_.id)
  def empty: Data515 = Data515(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data515 =
    Data515(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data515] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
