package generated

final case class Data948(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data948 = copy(name = name.toUpperCase)
  def scale(k: Double): Data948 = copy(value = value * k)
  def addTag(t: String): Data948 = copy(tags = t :: tags)
  def put(k: String, v: String): Data948 = copy(meta = meta.updated(k, v))
  def merge(other: Data948): Data948 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data948 {
  given Ordering[Data948] = Ordering.by(_.id)
  def empty: Data948 = Data948(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data948 =
    Data948(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data948] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
