package generated

final case class Data1494(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1494 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1494 = copy(value = value * k)
  def addTag(t: String): Data1494 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1494 = copy(meta = meta.updated(k, v))
  def merge(other: Data1494): Data1494 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1494 {
  given Ordering[Data1494] = Ordering.by(_.id)
  def empty: Data1494 = Data1494(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1494 =
    Data1494(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1494] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
