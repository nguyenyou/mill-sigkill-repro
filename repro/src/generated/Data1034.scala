package generated

final case class Data1034(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1034 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1034 = copy(value = value * k)
  def addTag(t: String): Data1034 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1034 = copy(meta = meta.updated(k, v))
  def merge(other: Data1034): Data1034 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1034 {
  given Ordering[Data1034] = Ordering.by(_.id)
  def empty: Data1034 = Data1034(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1034 =
    Data1034(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1034] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
