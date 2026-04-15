package generated

final case class Data915(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data915 = copy(name = name.toUpperCase)
  def scale(k: Double): Data915 = copy(value = value * k)
  def addTag(t: String): Data915 = copy(tags = t :: tags)
  def put(k: String, v: String): Data915 = copy(meta = meta.updated(k, v))
  def merge(other: Data915): Data915 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data915 {
  given Ordering[Data915] = Ordering.by(_.id)
  def empty: Data915 = Data915(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data915 =
    Data915(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data915] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
