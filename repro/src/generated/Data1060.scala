package generated

final case class Data1060(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1060 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1060 = copy(value = value * k)
  def addTag(t: String): Data1060 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1060 = copy(meta = meta.updated(k, v))
  def merge(other: Data1060): Data1060 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1060 {
  given Ordering[Data1060] = Ordering.by(_.id)
  def empty: Data1060 = Data1060(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1060 =
    Data1060(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1060] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
