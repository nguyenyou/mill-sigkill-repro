package generated

final case class Data954(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data954 = copy(name = name.toUpperCase)
  def scale(k: Double): Data954 = copy(value = value * k)
  def addTag(t: String): Data954 = copy(tags = t :: tags)
  def put(k: String, v: String): Data954 = copy(meta = meta.updated(k, v))
  def merge(other: Data954): Data954 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data954 {
  given Ordering[Data954] = Ordering.by(_.id)
  def empty: Data954 = Data954(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data954 =
    Data954(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data954] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
