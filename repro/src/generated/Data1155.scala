package generated

final case class Data1155(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1155 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1155 = copy(value = value * k)
  def addTag(t: String): Data1155 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1155 = copy(meta = meta.updated(k, v))
  def merge(other: Data1155): Data1155 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1155 {
  given Ordering[Data1155] = Ordering.by(_.id)
  def empty: Data1155 = Data1155(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1155 =
    Data1155(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1155] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
