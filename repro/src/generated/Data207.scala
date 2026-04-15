package generated

final case class Data207(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data207 = copy(name = name.toUpperCase)
  def scale(k: Double): Data207 = copy(value = value * k)
  def addTag(t: String): Data207 = copy(tags = t :: tags)
  def put(k: String, v: String): Data207 = copy(meta = meta.updated(k, v))
  def merge(other: Data207): Data207 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data207 {
  given Ordering[Data207] = Ordering.by(_.id)
  def empty: Data207 = Data207(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data207 =
    Data207(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data207] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
