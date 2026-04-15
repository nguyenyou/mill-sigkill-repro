package generated

final case class Data719(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data719 = copy(name = name.toUpperCase)
  def scale(k: Double): Data719 = copy(value = value * k)
  def addTag(t: String): Data719 = copy(tags = t :: tags)
  def put(k: String, v: String): Data719 = copy(meta = meta.updated(k, v))
  def merge(other: Data719): Data719 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data719 {
  given Ordering[Data719] = Ordering.by(_.id)
  def empty: Data719 = Data719(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data719 =
    Data719(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data719] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
