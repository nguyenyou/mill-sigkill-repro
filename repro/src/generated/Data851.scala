package generated

final case class Data851(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data851 = copy(name = name.toUpperCase)
  def scale(k: Double): Data851 = copy(value = value * k)
  def addTag(t: String): Data851 = copy(tags = t :: tags)
  def put(k: String, v: String): Data851 = copy(meta = meta.updated(k, v))
  def merge(other: Data851): Data851 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data851 {
  given Ordering[Data851] = Ordering.by(_.id)
  def empty: Data851 = Data851(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data851 =
    Data851(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data851] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
