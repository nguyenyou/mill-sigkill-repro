package generated

final case class Data1436(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1436 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1436 = copy(value = value * k)
  def addTag(t: String): Data1436 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1436 = copy(meta = meta.updated(k, v))
  def merge(other: Data1436): Data1436 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1436 {
  given Ordering[Data1436] = Ordering.by(_.id)
  def empty: Data1436 = Data1436(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1436 =
    Data1436(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1436] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
