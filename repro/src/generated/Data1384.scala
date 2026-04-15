package generated

final case class Data1384(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1384 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1384 = copy(value = value * k)
  def addTag(t: String): Data1384 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1384 = copy(meta = meta.updated(k, v))
  def merge(other: Data1384): Data1384 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1384 {
  given Ordering[Data1384] = Ordering.by(_.id)
  def empty: Data1384 = Data1384(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1384 =
    Data1384(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1384] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
