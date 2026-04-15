package generated

final case class Data1150(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1150 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1150 = copy(value = value * k)
  def addTag(t: String): Data1150 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1150 = copy(meta = meta.updated(k, v))
  def merge(other: Data1150): Data1150 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1150 {
  given Ordering[Data1150] = Ordering.by(_.id)
  def empty: Data1150 = Data1150(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1150 =
    Data1150(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1150] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
