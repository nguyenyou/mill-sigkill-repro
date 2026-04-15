package generated

final case class Data548(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data548 = copy(name = name.toUpperCase)
  def scale(k: Double): Data548 = copy(value = value * k)
  def addTag(t: String): Data548 = copy(tags = t :: tags)
  def put(k: String, v: String): Data548 = copy(meta = meta.updated(k, v))
  def merge(other: Data548): Data548 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data548 {
  given Ordering[Data548] = Ordering.by(_.id)
  def empty: Data548 = Data548(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data548 =
    Data548(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data548] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
