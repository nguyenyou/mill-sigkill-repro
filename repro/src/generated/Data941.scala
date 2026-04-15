package generated

final case class Data941(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data941 = copy(name = name.toUpperCase)
  def scale(k: Double): Data941 = copy(value = value * k)
  def addTag(t: String): Data941 = copy(tags = t :: tags)
  def put(k: String, v: String): Data941 = copy(meta = meta.updated(k, v))
  def merge(other: Data941): Data941 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data941 {
  given Ordering[Data941] = Ordering.by(_.id)
  def empty: Data941 = Data941(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data941 =
    Data941(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data941] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
