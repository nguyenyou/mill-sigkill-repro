package generated

final case class Data871(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data871 = copy(name = name.toUpperCase)
  def scale(k: Double): Data871 = copy(value = value * k)
  def addTag(t: String): Data871 = copy(tags = t :: tags)
  def put(k: String, v: String): Data871 = copy(meta = meta.updated(k, v))
  def merge(other: Data871): Data871 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data871 {
  given Ordering[Data871] = Ordering.by(_.id)
  def empty: Data871 = Data871(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data871 =
    Data871(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data871] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
