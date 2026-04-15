package generated

final case class Data102(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data102 = copy(name = name.toUpperCase)
  def scale(k: Double): Data102 = copy(value = value * k)
  def addTag(t: String): Data102 = copy(tags = t :: tags)
  def put(k: String, v: String): Data102 = copy(meta = meta.updated(k, v))
  def merge(other: Data102): Data102 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data102 {
  given Ordering[Data102] = Ordering.by(_.id)
  def empty: Data102 = Data102(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data102 =
    Data102(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data102] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
