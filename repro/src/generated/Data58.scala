package generated

final case class Data58(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data58 = copy(name = name.toUpperCase)
  def scale(k: Double): Data58 = copy(value = value * k)
  def addTag(t: String): Data58 = copy(tags = t :: tags)
  def put(k: String, v: String): Data58 = copy(meta = meta.updated(k, v))
  def merge(other: Data58): Data58 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data58 {
  given Ordering[Data58] = Ordering.by(_.id)
  def empty: Data58 = Data58(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data58 =
    Data58(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data58] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
