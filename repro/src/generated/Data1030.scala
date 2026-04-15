package generated

final case class Data1030(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1030 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1030 = copy(value = value * k)
  def addTag(t: String): Data1030 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1030 = copy(meta = meta.updated(k, v))
  def merge(other: Data1030): Data1030 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1030 {
  given Ordering[Data1030] = Ordering.by(_.id)
  def empty: Data1030 = Data1030(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1030 =
    Data1030(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1030] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
