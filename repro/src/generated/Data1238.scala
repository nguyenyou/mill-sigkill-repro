package generated

final case class Data1238(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1238 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1238 = copy(value = value * k)
  def addTag(t: String): Data1238 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1238 = copy(meta = meta.updated(k, v))
  def merge(other: Data1238): Data1238 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1238 {
  given Ordering[Data1238] = Ordering.by(_.id)
  def empty: Data1238 = Data1238(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1238 =
    Data1238(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1238] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
