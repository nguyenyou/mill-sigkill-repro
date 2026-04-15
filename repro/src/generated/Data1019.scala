package generated

final case class Data1019(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1019 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1019 = copy(value = value * k)
  def addTag(t: String): Data1019 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1019 = copy(meta = meta.updated(k, v))
  def merge(other: Data1019): Data1019 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1019 {
  given Ordering[Data1019] = Ordering.by(_.id)
  def empty: Data1019 = Data1019(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1019 =
    Data1019(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1019] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
