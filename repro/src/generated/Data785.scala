package generated

final case class Data785(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data785 = copy(name = name.toUpperCase)
  def scale(k: Double): Data785 = copy(value = value * k)
  def addTag(t: String): Data785 = copy(tags = t :: tags)
  def put(k: String, v: String): Data785 = copy(meta = meta.updated(k, v))
  def merge(other: Data785): Data785 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data785 {
  given Ordering[Data785] = Ordering.by(_.id)
  def empty: Data785 = Data785(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data785 =
    Data785(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data785] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
