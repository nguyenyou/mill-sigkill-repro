package generated

final case class Data494(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data494 = copy(name = name.toUpperCase)
  def scale(k: Double): Data494 = copy(value = value * k)
  def addTag(t: String): Data494 = copy(tags = t :: tags)
  def put(k: String, v: String): Data494 = copy(meta = meta.updated(k, v))
  def merge(other: Data494): Data494 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data494 {
  given Ordering[Data494] = Ordering.by(_.id)
  def empty: Data494 = Data494(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data494 =
    Data494(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data494] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
