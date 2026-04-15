package generated

final case class Data820(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data820 = copy(name = name.toUpperCase)
  def scale(k: Double): Data820 = copy(value = value * k)
  def addTag(t: String): Data820 = copy(tags = t :: tags)
  def put(k: String, v: String): Data820 = copy(meta = meta.updated(k, v))
  def merge(other: Data820): Data820 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data820 {
  given Ordering[Data820] = Ordering.by(_.id)
  def empty: Data820 = Data820(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data820 =
    Data820(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data820] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
