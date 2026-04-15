package generated

final case class Data1318(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1318 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1318 = copy(value = value * k)
  def addTag(t: String): Data1318 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1318 = copy(meta = meta.updated(k, v))
  def merge(other: Data1318): Data1318 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1318 {
  given Ordering[Data1318] = Ordering.by(_.id)
  def empty: Data1318 = Data1318(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1318 =
    Data1318(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1318] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
