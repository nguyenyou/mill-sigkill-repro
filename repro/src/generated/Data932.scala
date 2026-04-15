package generated

final case class Data932(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data932 = copy(name = name.toUpperCase)
  def scale(k: Double): Data932 = copy(value = value * k)
  def addTag(t: String): Data932 = copy(tags = t :: tags)
  def put(k: String, v: String): Data932 = copy(meta = meta.updated(k, v))
  def merge(other: Data932): Data932 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data932 {
  given Ordering[Data932] = Ordering.by(_.id)
  def empty: Data932 = Data932(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data932 =
    Data932(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data932] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
