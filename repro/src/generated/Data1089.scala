package generated

final case class Data1089(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1089 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1089 = copy(value = value * k)
  def addTag(t: String): Data1089 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1089 = copy(meta = meta.updated(k, v))
  def merge(other: Data1089): Data1089 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1089 {
  given Ordering[Data1089] = Ordering.by(_.id)
  def empty: Data1089 = Data1089(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1089 =
    Data1089(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1089] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
