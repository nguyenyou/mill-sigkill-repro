package generated

final case class Data1246(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1246 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1246 = copy(value = value * k)
  def addTag(t: String): Data1246 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1246 = copy(meta = meta.updated(k, v))
  def merge(other: Data1246): Data1246 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1246 {
  given Ordering[Data1246] = Ordering.by(_.id)
  def empty: Data1246 = Data1246(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1246 =
    Data1246(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1246] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
