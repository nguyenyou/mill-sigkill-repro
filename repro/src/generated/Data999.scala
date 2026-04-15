package generated

final case class Data999(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data999 = copy(name = name.toUpperCase)
  def scale(k: Double): Data999 = copy(value = value * k)
  def addTag(t: String): Data999 = copy(tags = t :: tags)
  def put(k: String, v: String): Data999 = copy(meta = meta.updated(k, v))
  def merge(other: Data999): Data999 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data999 {
  given Ordering[Data999] = Ordering.by(_.id)
  def empty: Data999 = Data999(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data999 =
    Data999(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data999] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
