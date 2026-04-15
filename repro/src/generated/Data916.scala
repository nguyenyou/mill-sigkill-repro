package generated

final case class Data916(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data916 = copy(name = name.toUpperCase)
  def scale(k: Double): Data916 = copy(value = value * k)
  def addTag(t: String): Data916 = copy(tags = t :: tags)
  def put(k: String, v: String): Data916 = copy(meta = meta.updated(k, v))
  def merge(other: Data916): Data916 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data916 {
  given Ordering[Data916] = Ordering.by(_.id)
  def empty: Data916 = Data916(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data916 =
    Data916(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data916] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
