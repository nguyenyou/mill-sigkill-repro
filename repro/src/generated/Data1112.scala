package generated

final case class Data1112(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1112 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1112 = copy(value = value * k)
  def addTag(t: String): Data1112 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1112 = copy(meta = meta.updated(k, v))
  def merge(other: Data1112): Data1112 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1112 {
  given Ordering[Data1112] = Ordering.by(_.id)
  def empty: Data1112 = Data1112(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1112 =
    Data1112(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1112] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
