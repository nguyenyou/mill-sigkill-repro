package generated

final case class Data683(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data683 = copy(name = name.toUpperCase)
  def scale(k: Double): Data683 = copy(value = value * k)
  def addTag(t: String): Data683 = copy(tags = t :: tags)
  def put(k: String, v: String): Data683 = copy(meta = meta.updated(k, v))
  def merge(other: Data683): Data683 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data683 {
  given Ordering[Data683] = Ordering.by(_.id)
  def empty: Data683 = Data683(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data683 =
    Data683(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data683] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
