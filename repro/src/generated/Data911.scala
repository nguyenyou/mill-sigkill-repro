package generated

final case class Data911(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data911 = copy(name = name.toUpperCase)
  def scale(k: Double): Data911 = copy(value = value * k)
  def addTag(t: String): Data911 = copy(tags = t :: tags)
  def put(k: String, v: String): Data911 = copy(meta = meta.updated(k, v))
  def merge(other: Data911): Data911 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data911 {
  given Ordering[Data911] = Ordering.by(_.id)
  def empty: Data911 = Data911(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data911 =
    Data911(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data911] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
