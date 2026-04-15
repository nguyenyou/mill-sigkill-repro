package generated

final case class Data747(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data747 = copy(name = name.toUpperCase)
  def scale(k: Double): Data747 = copy(value = value * k)
  def addTag(t: String): Data747 = copy(tags = t :: tags)
  def put(k: String, v: String): Data747 = copy(meta = meta.updated(k, v))
  def merge(other: Data747): Data747 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data747 {
  given Ordering[Data747] = Ordering.by(_.id)
  def empty: Data747 = Data747(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data747 =
    Data747(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data747] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
