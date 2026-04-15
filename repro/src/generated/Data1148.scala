package generated

final case class Data1148(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1148 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1148 = copy(value = value * k)
  def addTag(t: String): Data1148 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1148 = copy(meta = meta.updated(k, v))
  def merge(other: Data1148): Data1148 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1148 {
  given Ordering[Data1148] = Ordering.by(_.id)
  def empty: Data1148 = Data1148(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1148 =
    Data1148(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1148] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
