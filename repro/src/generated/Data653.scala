package generated

final case class Data653(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data653 = copy(name = name.toUpperCase)
  def scale(k: Double): Data653 = copy(value = value * k)
  def addTag(t: String): Data653 = copy(tags = t :: tags)
  def put(k: String, v: String): Data653 = copy(meta = meta.updated(k, v))
  def merge(other: Data653): Data653 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data653 {
  given Ordering[Data653] = Ordering.by(_.id)
  def empty: Data653 = Data653(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data653 =
    Data653(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data653] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
