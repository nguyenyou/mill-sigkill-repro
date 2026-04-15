package generated

final case class Data64(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data64 = copy(name = name.toUpperCase)
  def scale(k: Double): Data64 = copy(value = value * k)
  def addTag(t: String): Data64 = copy(tags = t :: tags)
  def put(k: String, v: String): Data64 = copy(meta = meta.updated(k, v))
  def merge(other: Data64): Data64 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data64 {
  given Ordering[Data64] = Ordering.by(_.id)
  def empty: Data64 = Data64(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data64 =
    Data64(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data64] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
