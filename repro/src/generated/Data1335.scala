package generated

final case class Data1335(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1335 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1335 = copy(value = value * k)
  def addTag(t: String): Data1335 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1335 = copy(meta = meta.updated(k, v))
  def merge(other: Data1335): Data1335 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1335 {
  given Ordering[Data1335] = Ordering.by(_.id)
  def empty: Data1335 = Data1335(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1335 =
    Data1335(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1335] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
