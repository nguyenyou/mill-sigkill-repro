package generated

final case class Data936(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data936 = copy(name = name.toUpperCase)
  def scale(k: Double): Data936 = copy(value = value * k)
  def addTag(t: String): Data936 = copy(tags = t :: tags)
  def put(k: String, v: String): Data936 = copy(meta = meta.updated(k, v))
  def merge(other: Data936): Data936 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data936 {
  given Ordering[Data936] = Ordering.by(_.id)
  def empty: Data936 = Data936(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data936 =
    Data936(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data936] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
